package funcionarios;

public abstract class Funcionario {

    protected String nome;
    protected String cpf;
    protected double taxaComissao;
    protected double vendasBrutas;

    public Funcionario(String nome, String cpf, double taxaComissao, double vendasBrutas){
        this.nome = nome;
        this.cpf = cpf;
        this.taxaComissao = taxaComissao;
        this.vendasBrutas = vendasBrutas;
    }

    public Funcionario(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    public Funcionario(){
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
}
