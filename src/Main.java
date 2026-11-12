public class Main {
    public static void main(String[] args) {
        int port = 1989;

        RequestHandler requestHandler = new ProfileRequestHandler();
        WebServer server = new WebServer(port, requestHandler);

        server.start();
    }
}
