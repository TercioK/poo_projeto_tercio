package dcx.ufpb.tercio.sistemaacai;

public class NaoEncontradoProdutoException extends RuntimeException {
    public NaoEncontradoProdutoException(String message) {
        super(message);
    }
}
