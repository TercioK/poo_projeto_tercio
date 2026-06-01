package dcx.ufpb.tercio.sistemafuncionarios;

import java.util.List;

public interface SistemaFuncionarios {
    public void cadastrarFuncionario(Funcionario funcionario) throws FuncionarioJaExisteException;
    public void cadastrarFuncionario(String cpf, String nome, TipoFuncionario tipoFuncionario, double salario) throws FuncionarioJaExisteException;
    public void alterarSalarioDeFuncionario(String cpfFuncionario, double novoSalario) throws FuncionarioInexistenteException;
    public int contarFuncionariosDoTipo(TipoFuncionario tipo);
    public boolean funcionarioJaExiste(String cpfFuncionario);
    public List<Funcionario> pesquisarFuncionario(TipoFuncionario tipo);
    public Funcionario pesquisarFuncionario(String cpfFuncionario) throws FuncionarioInexistenteException;
    public List<Funcionario> pesquisarFuncionariosComSalarioMaiorQue(double valor);
}
