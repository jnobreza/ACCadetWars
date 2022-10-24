package academiadecodigo.org.simplewebserver;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class NobisServer {

    public static void main(String[] args) throws Exception {

        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            while (true) {
                try (Socket client = serverSocket.accept()) {
                    handle(client);
                }
            }
        }
    }

    private static void handle(Socket client) throws IOException {

        System.out.println("Debug: got new client: " + client.toString());
        BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        
        StringBuilder requestBuilder = new StringBuilder();
        String line;
        while (!(line = reader.readLine()).isEmpty()){
            requestBuilder.append(line + "\r\n");
        }

        String request = requestBuilder.toString();
        //System.out.println(request);

        String[] requestsLines = request.split("\r\n");
        String[] requestLine = requestsLines[0].split(" ");
        String method = requestLine[0];
        String path = requestLine[1];
        String version = requestLine[2];
        String host = requestsLines[1].split(" ")[1];

        List<String> headers = new ArrayList<>();
        for(int h = 2; h < requestsLines.length; h++){
            String header = requestsLines[h];
            headers.add(header);
        }

        String accessLog = String.format("Client %s, method %s, path %s, version %s, host %s, headers %s",
                client.toString(), method, path, version, host, headers.toString());
        System.out.println(accessLog);

        Path filePath = getFilePath(path);
        if(Files.exists(filePath)) {
            String contentType = guessContentType(filePath);
            sendResponse(client, "200 OK", contentType, Files.readAllBytes(filePath));
        }else {
            byte[] takeItEasyContent = "<h1>Take it easy</h1>".getBytes();
            sendResponse(client, "420 Take it easy", "text/html", takeItEasyContent);

            }
        }

    private static void sendResponse(Socket client, String status, String contentType, byte[] readAllBytes) throws IOException {
        OutputStream clientOutput = client.getOutputStream();
        clientOutput.write("HTTP/1.1 200 OK\r\n".getBytes());
        clientOutput.write(("ContentType: text /html\r\n").getBytes());
        clientOutput.write("\r\n".getBytes());
        clientOutput.write("<b>It Works!<b>".getBytes());
        clientOutput.write("\r\n\r\n".getBytes());
        clientOutput.flush();
        client.close();
    }

    private static Path getFilePath(String path) {
        if ("/".equals(path)) {
            path = "/index.html";
        }
        return Paths.get("/tmp/www", path);
    }

    private static String guessContentType(Path filePath) throws IOException {
        return Files.probeContentType(filePath);
    }



}
