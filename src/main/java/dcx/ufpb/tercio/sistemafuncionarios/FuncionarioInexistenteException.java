package dcx.ufpb.tercio.sistemafuncionarios;

public class FuncionarioInexistenteException extends RuntimeException {
    public FuncionarioInexistenteException(String message) {
        super(message);
    }
}
