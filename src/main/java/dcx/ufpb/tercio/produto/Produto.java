package dcx.ufpb.tercio.produto;

public class Produto {
    private String nome;
    private double preco;
    private int estoque;

    public Produto(String nome, double preco, int estoque) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public String toString(){
        return "Nome do dcx.ufpb.tercio.produto.Produto: " + nome + " com o Preço de R$ " + preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public void venderProduto(int quantidade) {
        if (quantidade > estoque) {
            throw new EstoqueException("Quantidade de Produtos Invalidos!");
        }

        estoque -= quantidade;
    }
}
