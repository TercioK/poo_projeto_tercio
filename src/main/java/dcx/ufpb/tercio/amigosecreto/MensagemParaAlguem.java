package dcx.ufpb.tercio.amigosecreto;

public class MensagemParaAlguem extends Mensagem{
    private String emailDestinatario;

    public MensagemParaAlguem(String texto, String emailDestinatario, String emailRemetente, boolean anonima) {
        super(texto, emailDestinatario, anonima);
        this.emailDestinatario = emailDestinatario;
    }

    public String getEmailDestinatario() {
        return emailDestinatario;
    }

    public void setEmailDestinatario(String emailDestinatario) {
        this.emailDestinatario = emailDestinatario;
    }

    public String getTextoCompletoAExibir() {
        String formatarTexto = ehAnomina() ? "Anonimo" : getEmailDestinatario();
        return "Mensagem do Amigo Anonimo " + formatarTexto + " para a pessoa " + getTexto();
    }
}
