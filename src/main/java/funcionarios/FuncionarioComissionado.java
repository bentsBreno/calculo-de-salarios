package funcionarios;

public class FuncionarioComissionado extends Funcionario{
    public FuncionarioComissionado(String nome,
                                   String CPF,
                                   double taxaComissao,
                                   double vendasBrutas) {
        super(nome, CPF, taxaComissao, vendasBrutas);
    }

    @Override
    public double getRendimentos() {
        return taxaComissao * vendasBrutas;
    }
}
