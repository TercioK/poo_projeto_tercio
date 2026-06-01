package dcx.ufpb.tercio.amigosecreto;

public class Amigo {
    private String nome;
    private String email;
    private String emailAmigoSorteado;

    @Override
    public String toString() {
        return "Amigo Secreto: " + nome + " Email: " + email;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailAmigoSorteado() {
        return this.emailAmigoSorteado;
    }

    public void setEmailAmigoSorteado(String emailAmigoSorteado) {
        this.emailAmigoSorteado = emailAmigoSorteado;
    }
}
