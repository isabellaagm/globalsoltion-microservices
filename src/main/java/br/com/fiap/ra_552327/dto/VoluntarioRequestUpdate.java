package br.com.fiap.ra_552327.dto;

import br.com.fiap.ra_552327.model.Voluntario;

public class VoluntarioRequestUpdate {
    private String email;
    private String telefone;
    private String causa;

    public Voluntario toModel(Voluntario voluntario) {
        voluntario.setEmail(this.getEmail());
        voluntario.setTelefone(this.getTelefone());
        voluntario.setCausa(this.getCausa());
        return voluntario;
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
