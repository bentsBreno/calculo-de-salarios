package funcionarios;

public class FuncionarioAssalariado extends Funcionario{
    public FuncionarioAssalariado(String nome,
                                  String CPF,
                                  Double salario) {
        super(nome, CPF, salario);
    }

    @Override
    public double getRendimentos() {
        return getSalario();
    }
}
