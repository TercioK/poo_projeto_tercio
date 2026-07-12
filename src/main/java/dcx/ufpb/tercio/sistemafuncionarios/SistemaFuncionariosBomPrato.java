package dcx.ufpb.tercio.sistemafuncionarios;

import java.util.ArrayList;
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
        if (this.funcionarios.containsKey(funcionario.getCpf())) {
            throw new FuncionarioJaExisteException("Ja existe funcionario com o cpf " + funcionario.getCpf());
        } else {
            this.funcionarios.put(funcionario.getCpf(), funcionario);
        }
    }

    public void alterarSalarioDeFuncionario(String cpfFuncionario, double novoSalario) {
        if (!this.funcionarios.containsKey(cpfFuncionario)) {
            throw new FuncionarioInexistenteException("Funcionario com o CPF:" + cpfFuncionario + "não foi encontrado!");
        }

        for (Funcionario p : this.funcionarios.values()) {
            if (p.getCpf().equals(cpfFuncionario)) {
                p.setSalario(novoSalario);
            }
        }
    }

    public int contarFuncionariosDoTipo(TipoFuncionario tipo) {
        int funcionariosTotal = 0;

        for (Funcionario p : this.funcionarios.values()) {
            if (p.getTipo().equals(tipo)) {
                funcionariosTotal++;
            }
        }
        return funcionariosTotal;
    }

    public boolean funcionarioJaExiste(String cpfFuncionario) {
        for (Funcionario f : this.funcionarios.values()) {
            if (f.getCpf().equals(cpfFuncionario)) {
                return true;
            }
        }
        return false;
    }
    
    public List<Funcionario> pesquisarFuncionario(TipoFuncionario tipo) {
        List<Funcionario> funcionariosDoTipo = new ArrayList<>();

        for (Funcionario f : this.funcionarios.values()) {
            if (f.getTipo().equals(tipo)) {
                funcionariosDoTipo.add(f);
            }
        }
        return funcionariosDoTipo;
    }

    public List<Funcionario> pesquisarFuncionariosPorTipo(TipoFuncionario tipo) {
        return this.pesquisarFuncionario(tipo);
    }

    public Funcionario pesquisarFuncionario(String cpfFuncionario) {
        return this.funcionarios.get(cpfFuncionario);
    }

    public List<Funcionario> pesquisarFuncionariosComSalarioMaiorQue(double valor) {
        List<Funcionario> funcionariosMaior = new ArrayList<>();

        for (Funcionario p : this.funcionarios.values()) {
            if (p.getSalario() > valor) {
                funcionariosMaior.add(p);
            }
        }
        return funcionariosMaior;
    }
}
