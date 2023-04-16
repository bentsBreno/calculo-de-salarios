package funcionarios;

public class FuncionarioComissionadoBaseSalario extends FuncionarioComissionado{
    protected double salario;
    public FuncionarioComissionadoBaseSalario(String nome,
                                              String CPF,
                                              double taxaComissao,
                                              double vendasBrutas,
                                              double salario){
        super(nome, CPF, taxaComissao, vendasBrutas);
        this.salario = salario;
    }
    public double getRendimentos(){
        return salario + (taxaComissao * vendasBrutas);
    }
}
