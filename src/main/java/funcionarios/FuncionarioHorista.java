package funcionarios;

public class FuncionarioHorista extends Funcionario{
    private final int HORAS_SEMANAIS = 40;

    public FuncionarioHorista(String nome,
                              String CPF,
                              double taxaComissao,
                              double vendasBrutas,
                              double salarioHora,
                              double horasTrabalhadas) {
        super(nome, CPF, taxaComissao, vendasBrutas, salarioHora, horasTrabalhadas);
    }

    @Override
    public double getRendimentos() {
        if (horasTrabalhadas < HORAS_SEMANAIS) {
            return salario * horasTrabalhadas;
        }

        return gerarSalarioParaMaisQueAsHorasSemanais();
    }

    private double gerarSalarioParaMaisQueAsHorasSemanais(){
        double MULTIPLICADOR_SALARIO = 1.5;

        return HORAS_SEMANAIS * salario
                + (horasTrabalhadas - HORAS_SEMANAIS)
                * salario * MULTIPLICADOR_SALARIO;
    }
}
