import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ClientHandler implements Runnable {
    private final Socket clientSocket;
    private final RequestHandler requestHandler;

    public ClientHandler(Socket clientSocket, RequestHandler requestHandler) {
        this.clientSocket = clientSocket;
        this.requestHandler = requestHandler;
    }

    @Override
    public void run() {
        try (Socket socket = clientSocket;
             BufferedReader reader = new BufferedReader(
                     new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
             OutputStream output = socket.getOutputStream()) {

            String requestLine = reader.readLine();

            String headerLine;
            while ((headerLine = reader.readLine()) != null && !headerLine.isEmpty()) {

            }

            HttpRequest request = parseRequest(requestLine);
            HttpResponse response = requestHandler.handle(request);
            writeResponse(output, response);

        } catch (IOException e) {
            System.err.println("Istemci baglantisi hatasi: " + e.getMessage());
        }
    }

    private HttpRequest parseRequest(String requestLine) {
        if (requestLine == null || requestLine.isBlank()) {
            return new HttpRequest("", "", "");
        }

        String[] parts = requestLine.split(" ");
        if (parts.length < 3) {
            return new HttpRequest("", "", "");
        }

        return new HttpRequest(parts[0], parts[1], parts[2]);
    }

    private void writeResponse(OutputStream output, HttpResponse response)
            throws IOException {
        byte[] bodyBytes = response.getBody().getBytes(StandardCharsets.UTF_8);

        String headers =
                "HTTP/1.1 " + response.getStatusCode() + " "
                        + response.getReasonPhrase() + "\r\n"
                        + "Content-Type: " + response.getContentType() + "\r\n"
                        + "Content-Length: " + bodyBytes.length + "\r\n"
                        + "Connection: close\r\n"
                        + "\r\n";

        output.write(headers.getBytes(StandardCharsets.UTF_8));
        output.write(bodyBytes);
        output.flush();
    }
}
