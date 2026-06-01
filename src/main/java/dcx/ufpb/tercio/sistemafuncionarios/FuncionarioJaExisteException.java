package dcx.ufpb.tercio.sistemafuncionarios;

public class FuncionarioJaExisteException extends RuntimeException {
    public FuncionarioJaExisteException(String message) {
        super(message);
    }
}
