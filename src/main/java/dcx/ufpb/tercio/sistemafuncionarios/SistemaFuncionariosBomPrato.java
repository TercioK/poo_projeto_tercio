package dcx.ufpb.tercio.sistemafuncionarios;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class SistemaFuncionariosBomPrato implements SistemaFuncionarios {
    private Map<String, Funcionario> funcionarios;

    public SistemaFuncionariosBomPrato() {
        this.funcionarios = new HashMap<String, Funcionario>();
    }

    @Override
    public void cadastrarFuncionario(String cpf, String nome, TipoFuncionario tipo, double salario) throws FuncionarioJaExisteException {
        if (this.funcionarios.containsKey(cpf)) {
            throw new FuncionarioJaExisteException("Ja existe funcionario com o cpf " + cpf);
        } else {
            this.funcionarios.put(cpf, new Funcionario(cpf, nome, tipo, salario));
        }
    }

    public void cadastrarFuncionario(Funcionario funcionario) throws FuncionarioJaExisteException {
        // TODO
    }

    public void alterarSalarioDeFuncionario(String cpfFuncionario, double novoSalario) {
        // TODO
    }

    public int contarFuncionariosDoTipo(TipoFuncionario tipo) {
        // TODO
        return 0;
    }

    public boolean funcionarioJaExiste(String cpfFuncionario) {
        // TODO
        return false;
    }

    // QUE DIABO E ISSOOO
    public List<Funcionario> pesquisarFuncionario(TipoFuncionario tipo) {
        // TODO
        return null;
    }

    public List<Funcionario> pesquisarFuncionariosPorTipo(TipoFuncionario tipo) {
        // TODO
        return null;
    }

    public Funcionario pesquisarFuncionario(String cpfFuncionario) {
        // TODO
        return null;
    }

    public List<Funcionario> pesquisarFuncionariosComSalarioMaiorQue(double valor) {
        // TODO
        return null;
    }
}
