package main;
import funcionarios.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private  static final Scanner scanner = new Scanner(System.in);
    private static String nomeFuncionarioNovo;
    private static String cpfFuncionarioNovo;
    public static void main(String[] args){
        System.out.println("Bem vindo! Digite o número da ação desejada:");
        System.out.println(
                """
                1 - Criar um funcionário
                2 - Editar um funcionário
                3 - Visualizar os rendimentos de um funcionário
                4 - Sair""");

        int opcaoEscolhida = scanner.nextInt();

        if (nomeFuncionarioNovo != null) {
            nomeFuncionarioNovo = null;
            cpfFuncionarioNovo = null;
        }

        lidarComOpcaoEscolhida(opcaoEscolhida);
    }

    private static void lidarComOpcaoEscolhida(int opcaoEscolhida){
        try{
            switch (opcaoEscolhida) {
                case 1 -> abrirMenuDeCriacaoDeFuncionario();
                case 2 -> abrirMenuDeEdicaoDeFuncionario();
                case 3 -> abrirMenuDeExclusaoDeFuncionario();
                case 4 -> abrirMenuDeVisualizacaoDeRendimentos();
                default -> encerrar();
            }
        }
        catch (InterruptedException ex) {
            System.out.println("Um erro inesperado ocorreu. Por favor contate os DEVS.");
        }
    }

    private static void abrirMenuDeCriacaoDeFuncionario() throws InterruptedException {
        System.out.println("Qual é o nome do funcionário?");
        nomeFuncionarioNovo = scanner.next();

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
                taxaComissao, 0);
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

    }

    private static void abrirMenuDeExclusaoDeFuncionario() {

    }

    private static void abrirMenuDeVisualizacaoDeRendimentos() {

    }

    private static void encerrar() {

    }
}
