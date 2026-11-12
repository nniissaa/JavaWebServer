public class HttpResponse {
    private final int statusCode;
    private final String reasonPhrase;
    private final String contentType;
    private final String body;

    public HttpResponse(int statusCode, String reasonPhrase,
                        String contentType, String body) {
        this.statusCode = statusCode;
        this.reasonPhrase = reasonPhrase;
        this.contentType = contentType;
        this.body = body;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getReasonPhrase() {
        return reasonPhrase;
    }

    public String getContentType() {
        return contentType;
    }

    public String getBody() {
        return body;
    }
}
