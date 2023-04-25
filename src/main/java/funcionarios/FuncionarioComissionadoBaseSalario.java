package funcionarios;

public class FuncionarioComissionadoBaseSalario extends FuncionarioComissionado{
    public FuncionarioComissionadoBaseSalario(String nome,
                                              String CPF,
                                              double taxaComissao,
                                              double vendasBrutas,
                                              Double salario){
        super(nome, CPF, taxaComissao, vendasBrutas, salario);
    }
}
