package funcionarios;

public abstract class Funcionario {

    protected String nome;
    protected String cpf;
    protected double taxaComissao;
    protected double vendasBrutas;
    protected Double salario;
    protected Double horasTrabalhadas;

    public Funcionario(String nome,
                       String cpf,
                       double taxaComissao,
                       double vendasBrutas,
                       Double salario,
                       Double horasTrabalhadas){
        this.nome = nome;
        this.cpf = cpf;
        this.taxaComissao = taxaComissao;
        this.vendasBrutas = vendasBrutas;
        this.salario = salario;
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public Funcionario(
            String nome,
            String cpf,
            Double salario){
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
    }

    public abstract double getRendimentos();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        validarCpf(cpf);
        this.cpf = cpf;
    }

    public double getTaxaComissao() {
        return taxaComissao;
    }

    public void setTaxaComissao(double taxaComissao) {
        this.taxaComissao = taxaComissao;
    }

    public double getVendasBrutas() {
        return vendasBrutas;
    }

    public void setVendasBrutas(double vendasBrutas) {
        this.vendasBrutas = vendasBrutas;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public void setHorasTrabalhadas(Double horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    private void validarCpf(String cpf) {

        String cpf_validar = cpf.substring(0, cpf.length() - 2);
        int reverso = 10;
        int total = 0;
        for (int index = 0; index < 19; index++) {
            if (index > 8) {
                index -= 9;
            }
            total += (int)(cpf_validar.charAt(index)) * reverso;
            reverso--;
            if (reverso < 2) {
                reverso = 11;
                int d = 11 - (total % 11);
                if (d > 9) {
                    d = 0;
                }
                total = 0;
                cpf_validar += d;
            }
        }
        boolean sequencia = cpf_validar.equals(cpf_validar.charAt(0) + "".repeat(Math.max(0, cpf.length() - 2)));
        if (cpf.equals(cpf_validar) && !sequencia) {
            return;
        }
        throw new IllegalArgumentException ("Cpf inválido");
    }
}
