package dcx.ufpb.tercio.produto;

public class SemProdutosException extends RuntimeException {
    public SemProdutosException(String message) {
        super(message);
    }
}
