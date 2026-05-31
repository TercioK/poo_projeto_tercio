package dcx.ufpb.tercio.sistemaacai;

import java.io.IOException;

public interface AcaiInterface {
    public void cadastrarNovoPedido(String nomeCliente, String idCliente, String funcionario, String categoria, String produto, double preco, int quantidade);
    public void removerProdutoPeloNome(String nomeDoPedido) throws NaoEncontradoProdutoException;
    public void listarTodosProdutoLista();
    public AcaiProdutos pegarTodosProdutosCom(String nome);
    public void listarProdutosComNomeCliente(String nomeCliente);
    public void salvarDados() throws IOException;
    public void recuperarDados() throws IOException;
}
