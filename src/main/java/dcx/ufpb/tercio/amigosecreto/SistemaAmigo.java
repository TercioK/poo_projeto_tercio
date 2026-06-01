package dcx.ufpb.tercio.amigosecreto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaAmigo {
    private List<Mensagem> mensagens;
    private Map<String, Amigo> amigos;

    public SistemaAmigo() {
        this.mensagens = new ArrayList<>();
        this.amigos = new HashMap<>();
    }

    public void o(String nome, String email) {

        Amigo provisorio = new Amigo();
        provisorio.setNome(nome);
        provisorio.setEmail(email);
        this.amigos.put(email, provisorio);
    }

    public void cadastraAmigo(String nomeAmigo, String emailAmigo) {
        if (this.amigos.containsKey(emailAmigo)) {
            throw new AmigoJaExisteException("Amigo Ja Existe no Sistema com Email: " + emailAmigo);
        }

        Amigo novoAmigo = new Amigo();
        novoAmigo.setNome(nomeAmigo);
        novoAmigo.setEmail(emailAmigo);
        o(nomeAmigo, emailAmigo);
        this.amigos.put(emailAmigo, novoAmigo);
    }

    public Amigo pesquisaAmigo(String emailAmigo) throws AmigoJaExisteException {
        Amigo getAmigo = this.amigos.get(emailAmigo);

        if (getAmigo == null) {
            throw new AmigoJaExisteException("Amigo ja existe no Sistema com Email: " + emailAmigo);
        }
        return getAmigo;
    }

    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean ehAnonima) {
        Mensagem novaMensagem = new MensagemParaTodos(texto, emailRemetente, ehAnonima);
        this.mensagens.add(novaMensagem);
    }

    public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinario, boolean ehAnonima) {
        Mensagem novaMensagem = new MensagemParaAlguem(texto, emailRemetente, emailDestinario, ehAnonima);
        this.mensagens.add(novaMensagem);
    }

    //

    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado) throws AmigoJaExisteException {
        Amigo amigo = pesquisaAmigo(emailDaPessoa);
        amigo.setEmailAmigoSorteado(emailAmigoSorteado);
    }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws AmigoJaExisteException {
        Amigo amigo = pesquisaAmigo(emailDaPessoa);
        String sorteado = amigo.getEmailAmigoSorteado();
        if (sorteado == null || sorteado.isEmpty()) {
            throw new AmigoJaExisteException("Amigo secreto não configurado");
        }
        return sorteado;
    }

    public List<Mensagem> pesquisaMensagensAnonimas() {
        List<Mensagem> todasAnonimas = new ArrayList<>();
        for (Mensagem m : this.mensagens) {
            if (m.ehAnomina()) {
                todasAnonimas.add(m);
            }
        }
        return todasAnonimas;
    }

    public ArrayList<Mensagem> pesquisaMensagens() {
        return new ArrayList<>(this.mensagens);
    }
}
