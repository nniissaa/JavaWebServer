public class ProfileRequestHandler implements RequestHandler {
    private final ProfilePage profilePage;

    public ProfileRequestHandler() {
        this.profilePage = new ProfilePage();
    }

    @Override
    public HttpResponse handle(HttpRequest request) {
        if (!"GET".equals(request.getMethod())) {
            String message = "<h1>405 - Method Not Allowed</h1>";
            return new HttpResponse(405, "Method Not Allowed",
                    "text/html; charset=UTF-8", message);
        }

        if (!"/".equals(request.getPath()) && !"/index.html".equals(request.getPath())) {
            String message = "<h1>404 - Sayfa Bulunamadi</h1>";
            return new HttpResponse(404, "Not Found",
                    "text/html; charset=UTF-8", message);
        }

        return new HttpResponse(200, "OK",
                "text/html; charset=UTF-8", profilePage.createHtml());
    }
}
