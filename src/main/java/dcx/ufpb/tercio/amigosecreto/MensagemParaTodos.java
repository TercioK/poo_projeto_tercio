package dcx.ufpb.tercio.amigosecreto;

public class MensagemParaTodos extends Mensagem {
    public MensagemParaTodos(String texto, String emailRemetente, boolean ehAnonima) {
        super(texto, emailRemetente, ehAnonima);
    }

    public String getFormatadaEmTexto() {
        String formarEmTexto = ehAnomina() ? "Email Anomino: " : getEmailRemetente();
        return formarEmTexto;
    }
}
