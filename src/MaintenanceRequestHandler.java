public class MaintenanceRequestHandler implements RequestHandler {
    @Override
    public HttpResponse handle(HttpRequest request) {
        String html = """
                <!DOCTYPE html>
                <html lang="tr">
                <head><meta charset="UTF-8"><title>Bakim</title></head>
                <body>
                    <h1>Sunucu bakimda</h1>
                    <p>Lutfen daha sonra tekrar deneyiniz.</p>
                </body>
                </html>
                """;

        return new HttpResponse(200, "OK",
                "text/html; charset=UTF-8", html);
    }
}
