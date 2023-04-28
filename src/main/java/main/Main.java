package main;
import funcionarios.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private  static final Scanner scanner = new Scanner(System.in);
    private static String nomeFuncionarioNovo;
    private static String cpfFuncionarioNovo;
    private static Funcionario funcionarioSelecionado;

    public static void main(String[] args){
        System.out.println("Bem vindo! Digite o número da ação desejada:");
        int opcaoEscolhida = 0;

        while (opcaoEscolhida != 5){
            System.out.println(
                    """
                    1 - Criar um funcionário
                    2 - Editar um funcionário
                    3 - Visualizar os rendimentos de um funcionário
                    4 - Excluir um funcionário
                    5 - Sair""");

            opcaoEscolhida = scanner.nextInt();
            scanner.nextLine();                                                                                          // scanner.nextLine() é necessário:
                                                                                                                         // https://blog.terresquall.com/2022/08/javas-scanner-nextline-call-is-being-skipped/

            if (nomeFuncionarioNovo != null) {
                resetarNomeECpf();
            }

            try {

                lidarComOpcaoEscolhida(opcaoEscolhida);
            }catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        encerrar();
    }

    private static void resetarNomeECpf(){
        nomeFuncionarioNovo = null;
        cpfFuncionarioNovo = null;
    }

    private static void lidarComOpcaoEscolhida(int opcaoEscolhida){
        try{
            switch (opcaoEscolhida) {
                case 1 -> abrirMenuDeCriacaoDeFuncionario();
                case 2 -> abrirMenuDeEdicaoDeFuncionario();
                case 3 -> abrirMenuDeVisualizacaoDeRendimentos();
                case 4 -> abrirMenuDeExclusaoDeFuncionario();
                default -> encerrar();
            }
        }
        catch (InterruptedException ex) {
            System.out.println("Um erro inesperado ocorreu. Por favor contate os DEVS.");
        }
    }

    private static void abrirMenuDeCriacaoDeFuncionario() throws InterruptedException {
        System.out.println("Qual é o nome do funcionário?");
        nomeFuncionarioNovo = scanner.nextLine();


        System.out.println("Qual é o cpf do funcionário?");
        cpfFuncionarioNovo = scanner.next();

        System.out.println(
                """
                        Qual é o tipo deste funcionário? Informe o número da opção:
                        1 - Assalariado
                        2 - Comissionado (sem salário base)
                        3 - Comissionado (com salário base)
                        4 - Horista""");
        int tipoEscolhido = scanner.nextInt();

        Funcionario funcionarioCriado =
                exibirOpcoesAdicionaisDoTipoEscolhidoECriarFuncionario(tipoEscolhido);

        funcionarios.add(funcionarioCriado);
        System.out.println(nomeFuncionarioNovo + " Criado(a) com sucesso! Voltando para o menu inicial...");

        Thread.sleep(1500);
    }

    private static Funcionario exibirOpcoesAdicionaisDoTipoEscolhidoECriarFuncionario(int tipoEscolhido) {
        TipoFuncionarioEscolhido tipo = TipoFuncionarioEscolhido.values()[tipoEscolhido - 1];

        switch (tipo){
            case ASSALARIADO -> {
                return criarFuncionarioAssalariado();
            }
            case COMISSIONADO_SEM_SALARIO_BASE -> {
                return criarFuncionarioComissionado();
            }
            case COMISSIONADO_COM_SALARIO_BASE -> {
                return criarFuncionarioComissionadoComSalarioBase();
            }
            case HORISTA -> {
                return criarFuncionarioHorista();
            }
        }

        throw new IllegalArgumentException("Tipo escolhido é inválido: " + tipoEscolhido);
    }

    private static FuncionarioAssalariado criarFuncionarioAssalariado() {
        System.out.println("Qual é o salário semanal do(a) " + nomeFuncionarioNovo + "?");
        System.out.println("Exemplo: 1200.00");
        double salario = scanner.nextFloat();

        return new FuncionarioAssalariado(
                nomeFuncionarioNovo,
                cpfFuncionarioNovo,
                salario);
    }

    private static FuncionarioComissionadoBaseSalario criarFuncionarioComissionadoComSalarioBase() {
        System.out.println("Qual é a taxa de comissão do(a) "
                + nomeFuncionarioNovo
                + " em porcentagem?");

        System.out.println("Exemplo: 50");
        double taxaComissao = scanner.nextFloat();

        System.out.println("Qual é o salário base do(a) "
                + nomeFuncionarioNovo + "?");

        System.out.println("Exemplo: 1200.00");
        double salarioBase = scanner.nextFloat();

        return new FuncionarioComissionadoBaseSalario(
                nomeFuncionarioNovo,
                cpfFuncionarioNovo,
                taxaComissao,
                0,
                salarioBase);
    }

    private static FuncionarioComissionado criarFuncionarioComissionado() {
        System.out.println("Qual é a taxa de comissão do(a) "
                + nomeFuncionarioNovo
                + " em porcentagem?");

        System.out.println("Exemplo: 50");

        double taxaComissao = scanner.nextFloat();

        return new FuncionarioComissionado(
                nomeFuncionarioNovo,
                cpfFuncionarioNovo,
                taxaComissao,
                0,
                null);
    }

    private static FuncionarioHorista criarFuncionarioHorista() {
        System.out.println("Qual é a taxa de comissão do(a) "
                + nomeFuncionarioNovo
                + " em porcentagem?");

        System.out.println("Exemplo: 50");
        double taxaComissao = scanner.nextFloat();

        System.out.println("Qual é o salário por hora do(a) "
                + nomeFuncionarioNovo + "?");

        System.out.println("Exemplo: 200.00");
        double salarioHora = scanner.nextFloat();

        return new FuncionarioHorista(
                nomeFuncionarioNovo,
                cpfFuncionarioNovo,
                taxaComissao,
                0,
                salarioHora,
                0);
    }

    private static void abrirMenuDeEdicaoDeFuncionario() {
        System.out.println("Digite o número do funcionário que deseja editar:");
        abrirMenuDeSelecaoDeFuncionario();

        System.out.println("Você está editando o(a)" + funcionarioSelecionado.getNome());
        System.out.println("CPF: " + funcionarioSelecionado.getCpf());

        boolean ehAssalariado = funcionarioSelecionado.getClass() == FuncionarioAssalariado.class;
        boolean ehComissionado = funcionarioSelecionado.getClass() == FuncionarioComissionado.class;

        if (ehAssalariado){
            System.out.println("Salário semanal: " + funcionarioSelecionado.getRendimentos());
        }

        System.out.println("Vendas brutas: " + funcionarioSelecionado.getVendasBrutas());

        if (ehComissionado){
            System.out.println("Comissão: " + funcionarioSelecionado.getTaxaComissao() + "\n" +
                    "Rendimentos: " + funcionarioSelecionado.getRendimentos());
        }

        int opcaoEscolhida = -1;

        while (opcaoEscolhida != 0){
            System.out.println("""
                        ------------------------------------
                        O que você deseja alterar?
                        1 - Nome
                        2 - CPF
                        3 - Vendas brutas
                        4 - Horas trabalhadas
                        """
            );

            if (ehAssalariado){
                System.out.print("5 - Salário");
            }else{
                System.out.print("6 - Comissão");
            }

            System.out.println("""

                    0 - Voltar para o menu principal
                    ------------------------------------""");

            opcaoEscolhida = scanner.nextInt();
            scanner.nextLine();

            try {
                lidarComOpcaoEscolhidaMenuDeEdicao(opcaoEscolhida);
            } catch (InterruptedException ex){
                System.out.println("Um erro inesperado ocorreu. Por favor contate os DEVS.");
            }
        }
    }

    private static void abrirMenuDeSelecaoDeFuncionario(){
        int posicao = 0;

        for (Funcionario funcionario: funcionarios) {
            posicao++;
            System.out.printf(
                    "[%s] %s%n",
                    posicao,
                    funcionario.getNome());
        }

        int posicaoSelecionada = scanner.nextInt() - 1;
        funcionarioSelecionado = funcionarios.get(posicaoSelecionada);
    }

    private static void lidarComOpcaoEscolhidaMenuDeEdicao(int opcaoEscolhida) throws InterruptedException {
        switch (opcaoEscolhida){
            case 1 -> {
                System.out.print("Novo nome: ");
                String nome = scanner.nextLine();
                funcionarioSelecionado.setNome(nome);
                System.out.println("Novo nome: " + nome + " definido com sucesso!");
            }
            case 2 -> {
                System.out.print("Novo CPF: ");
                String novoCpf = scanner.next();
                funcionarioSelecionado.setCpf(novoCpf);
                System.out.println("Novo CPF: " + novoCpf + " definido com sucesso!");
            }
            case 3 -> {
                System.out.print("Vendas brutas atualizadas: ");
                double novasVendas = scanner.nextDouble();
                funcionarioSelecionado.setVendasBrutas(novasVendas);
                System.out.println("Nova(s) venda(s) bruta(s): " + novasVendas + " definida(s) com sucesso!");
            }
            case 4 -> {
                System.out.print("Horas trabalhadas atualizadas: ");
                Double novasHoras = scanner.nextDouble();
                funcionarioSelecionado.setHorasTrabalhadas(novasHoras);
                System.out.println("Novas horas: " + novasHoras + " definidas com sucesso!");
            }
            case 5 -> {
                System.out.print("Salario atualizado: ");
                Double novoSalario = scanner.nextDouble();
                funcionarioSelecionado.setSalario(novoSalario);
                System.out.println("Novo salário: " + novoSalario + " definido com sucesso!");
            }
            case 6 -> {
                System.out.print("Comissão atualizada: ");
                double novaComissao = scanner.nextDouble();
                funcionarioSelecionado.setTaxaComissao(novaComissao);
                System.out.println("Novo nome: " + novaComissao + " definido com sucesso!");
            }
        }

        Thread.sleep(1000);
    }

    private static void abrirMenuDeExclusaoDeFuncionario() {
        System.out.println("Escolha o numero do funcionário que deseja excluir:");
        abrirMenuDeSelecaoDeFuncionario();

        funcionarios.remove(funcionarioSelecionado);
        System.out.println("Funcionario removido com sucesso!");
    }

    private static void abrirMenuDeVisualizacaoDeRendimentos() {
        System.out.println("Escolha o numero do funcionário que deseja visualizar os rendimentos:");
        abrirMenuDeSelecaoDeFuncionario();

        System.out.println("\n" +
                "Rendimentos do(a) " +
                funcionarioSelecionado.getNome() +
                ": " +
                funcionarioSelecionado.getRendimentos() +
                "\n");
    }

    private static void encerrar() {
        System.out.println("\n" + "Encerrando...");
        System.exit(1);
    }

}
