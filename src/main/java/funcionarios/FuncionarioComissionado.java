package funcionarios;

public class FuncionarioComissionado extends Funcionario{
    public FuncionarioComissionado(String nome,
                                   String CPF,
                                   double taxaComissao,
                                   double vendasBrutas,
                                   Double salario) {
        super(nome, CPF, taxaComissao, vendasBrutas, salario, null);
    }

    @Override
    public double getRendimentos() {
        return salario + (taxaComissao * 0.01) * vendasBrutas;
    }
}
