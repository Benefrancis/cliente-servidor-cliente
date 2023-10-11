package br.com.benefrancis.domain.resources;

import br.com.benefrancis.domain.service.EnderecoService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Objects;

@Path("/endereco")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EnderecoResource {


    private EnderecoService service = new EnderecoService();

    @GET
    @Path("/cep/{cep}")
    public Response findByCEP(@PathParam("cep") String CEP) {
        var endereco = service.findByCEP(CEP);
        if (Objects.isNull(endereco)) return Response.status(404).entity(endereco).build();
        return Response.ok(endereco).build();
    }

    @GET
    @Path("/")
    public Response findByCEP(@QueryParam("uf") String uf, @QueryParam("cidade") String cidade, @QueryParam("logradouro") String logradouro) {
        var enderecos = service.findByLogradouro(uf, cidade, logradouro);
        if (Objects.isNull(enderecos)) return Response.status(404).entity(enderecos).build();
        return Response.ok(enderecos).build();
    }


}
