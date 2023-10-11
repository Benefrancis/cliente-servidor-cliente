package br.com.benefrancis.domain.service;

import br.com.benefrancis.domain.entity.Endereco;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import jakarta.ws.rs.core.UriBuilder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.security.URIParameter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class EnderecoService {

    private final String FONTE = "http://viacep.com.br/ws/";

    public Endereco findByCEP(String CEP) {

        Endereco endereco = null;

        URI uri = null;

        HttpResponse<String> response = null;


        try {

            uri = new URI(this.FONTE + CEP + "/json");

            var cliente = HttpClient.newHttpClient();

            var request = HttpRequest.newBuilder(uri).GET().build();

            response = cliente.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new RuntimeException("HTTP error code : " + response.statusCode());
            }

            var body = response.body();

            endereco = new Gson().fromJson(body, Endereco.class);

        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return endereco;

    }

    //"viacep.com.br/ws/RS/Porto Alegre/Domingos/json/"
    public List<Endereco> findByLogradouro(String uf, String cidade, String logradouro) {

        List<Endereco> enderecos = new ArrayList<>();

        URI uri = null;

        HttpResponse<String> response = null;

        Type tipo = new TypeToken<ArrayList<Endereco>>() {
        }.getType();

        try {

            var value = this.FONTE + uf + "/" + encode(cidade) + "/" + encode(logradouro) + "/json";

            uri = new URI(value);

            var cliente = HttpClient.newHttpClient();

            var request = HttpRequest.newBuilder(URI.create(uri.toASCIIString())).GET().build();

            response = cliente.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                return null;
                // throw new RuntimeException("HTTP error code : " + response.statusCode());
            }

            var body = response.body();

            enderecos = new Gson().fromJson(body, tipo);


        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        return enderecos;

    }

    private static String encode(String value) throws UnsupportedEncodingException {
        value = value.replace(" ", "%20").replace("#", "%23");
        return value;
    }


}
