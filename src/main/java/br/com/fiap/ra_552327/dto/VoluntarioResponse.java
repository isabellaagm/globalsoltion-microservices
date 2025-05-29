package br.com.fiap.ra_552327.dto;

import br.com.fiap.ra_552327.model.Voluntario;

public class VoluntarioResponse {
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String causa;


    public VoluntarioResponse toDto(Voluntario voluntario) {
        this.setId(voluntario.getId());
        this.setNome(voluntario.getNome());
        this.setEmail(voluntario.getEmail());
        this.setTelefone(voluntario.getTelefone());
        this.setCausa(voluntario.getCausa());
        return this;
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
