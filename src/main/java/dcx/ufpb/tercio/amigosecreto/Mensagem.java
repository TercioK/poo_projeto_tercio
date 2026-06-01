package dcx.ufpb.tercio.amigosecreto;

public class Mensagem {
    private String texto;
    private String emailRemetente;
    private boolean anomina;

    public Mensagem(String texto, String emailRemetente, boolean anomina) {
        this.texto = texto;
        this.emailRemetente = emailRemetente;
        this.anomina = anomina;
    }

    public Mensagem() {
        this("", "", true);
    }

    public String getTexto() {
        return this.texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getTextoCompletoAExibir() {
        // TODO
        return null;
    }

    public String getEmailRemetente() {
        return this.emailRemetente;
    }

    public void setEmailRemetente(String emailRemetente) {
        this.emailRemetente = emailRemetente;
    }

    public boolean ehAnomina() {
        return this.anomina;
    }
}
