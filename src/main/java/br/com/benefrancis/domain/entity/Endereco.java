package br.com.benefrancis.domain.entity;

public class Endereco {

    private String cep;

    private String logradouro;

    private String complemento;

    private String bairro;

    private String localidade;

    private String uf;

    private String IBGE;

    private String GUIA;

    private String ddd;

    private String SIAFI;

    public Endereco() {
    }

    public Endereco(String cep, String logradouro, String complemento, String bairro, String localidade, String uf, String IBGE, String GUIA, String ddd, String SIAFI) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
        this.IBGE = IBGE;
        this.GUIA = GUIA;
        this.ddd = ddd;
        this.SIAFI = SIAFI;
    }

    public String getCep() {
        return cep;
    }

    public Endereco setCep(String cep) {
        this.cep = cep;
        return this;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public Endereco setLogradouro(String logradouro) {
        this.logradouro = logradouro;
        return this;
    }

    public String getComplemento() {
        return complemento;
    }

    public Endereco setComplemento(String complemento) {
        this.complemento = complemento;
        return this;
    }

    public String getBairro() {
        return bairro;
    }

    public Endereco setBairro(String bairro) {
        this.bairro = bairro;
        return this;
    }

    public String getLocalidade() {
        return localidade;
    }

    public Endereco setLocalidade(String localidade) {
        this.localidade = localidade;
        return this;
    }

    public String getUf() {
        return uf;
    }

    public Endereco setUf(String uf) {
        this.uf = uf;
        return this;
    }

    public String getIBGE() {
        return IBGE;
    }

    public Endereco setIBGE(String IBGE) {
        this.IBGE = IBGE;
        return this;
    }

    public String getGUIA() {
        return GUIA;
    }

    public Endereco setGUIA(String GUIA) {
        this.GUIA = GUIA;
        return this;
    }

    public String getDdd() {
        return ddd;
    }

    public Endereco setDdd(String ddd) {
        this.ddd = ddd;
        return this;
    }

    public String getSIAFI() {
        return SIAFI;
    }

    public Endereco setSIAFI(String SIAFI) {
        this.SIAFI = SIAFI;
        return this;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", localidade='" + localidade + '\'' +
                ", uf='" + uf + '\'' +
                ", IBGE='" + IBGE + '\'' +
                ", GUIA='" + GUIA + '\'' +
                ", ddd='" + ddd + '\'' +
                ", SIAFI='" + SIAFI + '\'' +
                '}';
    }
}
