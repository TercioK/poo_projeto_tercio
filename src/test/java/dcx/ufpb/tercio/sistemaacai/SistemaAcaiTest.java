package dcx.ufpb.tercio.sistemaacai;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SistemaAcaiTest {
    private SistemaAcai sistema;

    @BeforeEach
    public void ativarSistema() {
        sistema = new SistemaAcai();
    }

    @Test
    public void testCadastrarNovoPedidoEBuscar() {
        sistema.cadastrarNovoPedido("Natan", "123", "Tercio", "Copos", "Açai 500ml", 18.50, 2);
        AcaiProdutos produtoRecuperado = sistema.pegarTodosProdutosCom("Açai 500ml");

        assertEquals("Natan", produtoRecuperado.getNomeDoCliente(), "O nome do cliente deve ser Ayla.");
        assertEquals("123", produtoRecuperado.getIdDoCliente(), "O ID do cliente deve ser 123.");
        assertEquals("Açai 500ml", produtoRecuperado.getProdutoEscolhido(), "O produto deve ser Açai 500ml.");
        assertEquals(18.50, produtoRecuperado.getPrecoDoProduto(), 0.001, "O preço deve ser 18.50.");
        assertEquals(2, produtoRecuperado.getQuantidadeProduto(), "A quantidade deve ser 2.");
    }
}