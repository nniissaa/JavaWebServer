import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
    private final int port;
    private final RequestHandler requestHandler;

    public WebServer(int port, RequestHandler requestHandler) {
        this.port = port;
        this.requestHandler = requestHandler;
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Web sunucusu baslatildi.");
            System.out.println("Adres: http://localhost:" + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                Thread clientThread =
                        new Thread(new ClientHandler(clientSocket, requestHandler));
                clientThread.start();
            }
        } catch (IOException e) {
            System.err.println("Sunucu baslatilamadi: " + e.getMessage());
        }
    }
}
