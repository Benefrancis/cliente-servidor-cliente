package br.com.benefrancis;

import br.com.benefrancis.infra.ConnectionFactory;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

public class Main {

    private static final String BASE_URI = "http://localhost/api/";

    public static HttpServer startServer() {
        // Configure container response filters (CORSFilter)
        // Configure ConnectionFactory
        // Configure os pacotes em que temos Recursos da API REST
        final ResourceConfig rc = new ResourceConfig()
                .register(ConnectionFactory.build())
                .packages("br.com.benefrancis.domain.resources");
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    public static void main(String[] args) {

        var server = startServer();
        System.out.println(String.format(
                "Endereco app started with endpoints available " +
                        "as %s%nHit Ctrl-C to stop it....", BASE_URI));
        try {
            System.in.read();
            server.stop();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}