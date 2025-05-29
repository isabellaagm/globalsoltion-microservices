package br.com.fiap.ra_552327.dto;

import br.com.fiap.ra_552327.model.Voluntario;

public class VoluntarioRequestCreate {
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String causa;

    public Voluntario toModel() {
        Voluntario voluntario = new Voluntario();
        voluntario.setNome(this.getNome());
        voluntario.setEmail(this.getEmail());
        voluntario.setTelefone(this.getTelefone());
        voluntario.setCausa(this.getCausa());
        return voluntario;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getCausa() {
        return causa;
    }
    public void setCausa(String causa) {
        this.causa = causa;
    }

    
}
