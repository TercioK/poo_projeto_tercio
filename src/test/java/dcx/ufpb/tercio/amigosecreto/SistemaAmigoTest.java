package dcx.ufpb.tercio.amigosecreto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SistemaAmigoTest {

	SistemaAmigo sistema;

	@BeforeEach
	void setUp()  {
		this.sistema = new SistemaAmigo();
	}

	@Test
	void testSistemaAmigo() {
		assertTrue(sistema.pesquisaMensagens().isEmpty());
		assertThrows(AmigoJaExisteException.class,
				()-> sistema.pesquisaAmigo("ayla@teste.com"));
	}

	@Test
	void testPesquisaECadastraAmigo() {
		try {
			sistema.pesquisaAmigo("ayla@teste.com");
			fail("Deveria falhar pois não existe ainda");
		} catch (AmigoJaExisteException e) {
			//Ok
		}
		try {
			sistema.cadastraAmigo("ayla", "ayla@teste.com");
			Amigo a = sistema.pesquisaAmigo("ayla@teste.com");
			assertEquals("ayla", a.getNome());
			assertEquals("ayla@teste.com", a.getEmail());
		} catch (AmigoJaExisteException e) {
			fail("Não deveria lançar exceção");
		}
	}

	@Test
	void testEnviarMensagemParaTodos() {
		assertTrue(sistema.pesquisaMensagens().isEmpty());
		sistema.enviarMensagemParaTodos("texto", "ayla@dcx.ufpb.br", true);
		List<Mensagem> mensagensAchadas = sistema.pesquisaMensagens();
		assertTrue(mensagensAchadas.size()==1);
		assertTrue(mensagensAchadas.get(0).getEmailRemetente().equals("ayla@dcx.ufpb.br"));
	}

	@Test
	void testEnviarMensagemParaAlguem() {
		assertTrue(sistema.pesquisaMensagens().isEmpty());
		sistema.enviarMensagemParaAlguem("texto", "ayla@dcx.ufpb.br", "rodrigo@dcx.ufpb.br", true);
		List<Mensagem> mensagensAchadas = sistema.pesquisaMensagens();
		assertEquals(1, mensagensAchadas.size());
		assertTrue(mensagensAchadas.get(0) instanceof MensagemParaAlguem);
		assertTrue(mensagensAchadas.get(0).getTexto().equals("texto"));
	}

	@Test
	void testPesquisaMensagensAnonimas() {
		assertTrue(sistema.pesquisaMensagens().isEmpty());
		sistema.enviarMensagemParaAlguem("texto 1", "ayla@dcx.ufpb.br", "rodrigo@dcx.ufpb.br", false);
		assertTrue(sistema.pesquisaMensagensAnonimas().isEmpty());
		sistema.enviarMensagemParaAlguem("texto 2", "ayla@dcx.ufpb.br", "rodrigo@dcx.ufpb.br", true);
		assertTrue(sistema.pesquisaMensagensAnonimas().size()==1);
	}

	@Test
	void testPesquisaTodasAsMensagens() {
		assertTrue(sistema.pesquisaMensagens().isEmpty());
		sistema.enviarMensagemParaAlguem("texto 1", "ayla@dcx.ufpb.br", "rodrigor@dcx.ufpb.br", false);
		assertTrue(sistema.pesquisaMensagens().size()==1);
		sistema.enviarMensagemParaAlguem("texto 2", "ayla@dcx.ufpb.br", "rodrigor@dcx.ufpb.br", true);
		assertTrue(sistema.pesquisaMensagens().size()==2);
	}

	@Test
	void testPesquisaAmigoEConfiguraAmigoSecretoDe() {
		assertThrows(AmigoJaExisteException.class,
				()-> sistema.pesquisaAmigoSecretoDe("ayla@dcx.ufpb.br"));
		try {
			sistema.cadastraAmigo("Ayla", "ayla@dcx.ufpb.br");
			sistema.cadastraAmigo("Ana", "ana@dcx.ufpb.br");
			sistema.configuraAmigoSecretoDe("ayla@dcx.ufpb.br", "ana@dcx.ufpb.br");
			sistema.configuraAmigoSecretoDe("ana@dcx.ufpb.br", "ayla@dcx.ufpb.br");
			assertEquals("ana@dcx.ufpb.br", sistema.pesquisaAmigoSecretoDe("ayla@dcx.ufpb.br"));
			assertEquals("ayla@dcx.ufpb.br", sistema.pesquisaAmigoSecretoDe("ana@dcx.ufpb.br"));
		} catch (AmigoJaExisteException e) {
			fail("Não deveria lançar exceção");
		}
	}
}