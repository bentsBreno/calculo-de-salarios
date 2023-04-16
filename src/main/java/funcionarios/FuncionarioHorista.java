package funcionarios;

public class FuncionarioHorista extends Funcionario{
    protected double salarioHora;
    protected double horasTrabalhadas;
    private final int HORAS_SEMANAIS = 40;
    private final double MULTIPLICADOR_SALARIO = 1.5;
    public FuncionarioHorista(String nome,
                              String CPF,
                              double taxaComissao,
                              double vendasBrutas,
                              double salarioHora,
                              double horasTrabalhadas) {
        super(nome, CPF, taxaComissao, vendasBrutas);
        this.salarioHora = salarioHora;
        this.horasTrabalhadas = horasTrabalhadas;
    }

    @Override
    public double getRendimentos() {
        if (horasTrabalhadas < HORAS_SEMANAIS) {
            return salarioHora * horasTrabalhadas;
        }

        return gerarSalarioParaMaisQueAsHorasSemanais();
    }

    private double gerarSalarioParaMaisQueAsHorasSemanais(){
        return HORAS_SEMANAIS * salarioHora
                + (horasTrabalhadas - HORAS_SEMANAIS)
                * salarioHora * MULTIPLICADOR_SALARIO;
    }
}
