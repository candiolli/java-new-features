package com.candiolli.simpleHttp;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class NewHttpClient {

    public static void main(String[] args) throws IOException, InterruptedException {
        // Start the server
        startServer();

        Thread.sleep(3000);

        // Create client
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .followRedirects(HttpClient.Redirect.NORMAL)
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8001/test"))
                .timeout(Duration.ofMinutes(1))
                .header("Content-type", "application/json")
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(res -> { System.out.println(res.statusCode());
                                        return res; })
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println);
    }

    private static void startServer() throws IOException {
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);

        HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 8001), 0);
        server.createContext("/test", new MyHttpHandler());
        server.setExecutor(threadPoolExecutor);
        server.start();
    }
}
