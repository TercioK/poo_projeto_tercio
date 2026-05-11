package dcx.ufpb.tercio.produto;

import java.util.ArrayList;

public class SistemaProdutos {
    private ArrayList<Produto> listaProdutos;

    public SistemaProdutos() {
        this.listaProdutos = new ArrayList<>();
    }

    public void adicionarProdutosLista(Produto produto) {
        listaProdutos.add(produto);
    }

    public void listarListaProdutos() {
        if (listaProdutos.isEmpty()) {
            throw new SemProdutosException("Nenhum produto encontrado");
        }

        for (Produto p : listaProdutos) {
            System.out.println(p);
        }
    }

    public Produto getProdutoLista(String nome) {
        for (Produto p : listaProdutos) {
            if (p.getNome().equals(nome)) {
                return p;
            }
        }

        throw new SemProdutosException("Nenhum produto encontrado");
    }
}