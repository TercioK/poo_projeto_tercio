package dcx.ufpb.tercio.produto;

import java.util.Scanner;

public class ProgramaProduto {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        SistemaProdutos sistema = new SistemaProdutos();
        int painelCompras = -1;

        while (painelCompras != 0) {
            System.out.println("Sistema Basico de Produtos \n\n Digite 1 para Adicionar Produtos\n Digite 2 pra Listar Produtos");
            System.out.println("Digite a Opçao:");
            int escolhaPainel = sc.nextInt();

            if (escolhaPainel == 1) {
                try {
                    System.out.println("Digite o nome do dcx.ufpb.tercio.produto.Produto: ");
                    String nomeProduto = sc.nextLine();
                    sc.nextLine();

                    System.out.println("Digite o Preço do dcx.ufpb.tercio.produto.Produto: ");
                    double precoProduto = sc.nextDouble();

                    System.out.println("Digite o Estoque do dcx.ufpb.tercio.produto.Produto: ");
                    int estoqueProduto = sc.nextInt();

                    Produto novoProduto = new Produto(nomeProduto, precoProduto, estoqueProduto);
                    sistema.adicionarProdutosLista(novoProduto);
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }
            } else if (escolhaPainel == 2) {
                try {
                    System.out.println("LISTA DE TODOS OS PRODUTOS CADASTRDOS");
                    sistema.listarListaProdutos();
                } catch (SemProdutosException e) {
                    System.out.println(e.getMessage());
                }
            } else if (escolhaPainel == 3) {
                System.out.println("Fechando o Painel. Obrigado por usar! :)");
                painelCompras = 0;
                break;
            } else {
                System.out.println("Voce digitou um numero que e valido na lista de opçoes!");
            }
        }
        sc.close();
    }
}
