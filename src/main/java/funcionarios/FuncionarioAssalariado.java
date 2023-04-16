package funcionarios;

public class FuncionarioAssalariado extends Funcionario{
    protected double salarioSemanal;
    public FuncionarioAssalariado(String nome,
                                  String CPF,
                                  double salario) {
        super(nome, CPF);
        this.salarioSemanal = salario;
    }

    //TODO rever isso
    @Override
    public double getRendimentos() {
        return salarioSemanal;
    }

    public double getSalarioSemanal() {
        return salarioSemanal;
    }

    public void setSalarioSemanal(double salarioSemanal) {
        this.salarioSemanal = salarioSemanal;
    }
}
