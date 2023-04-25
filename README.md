# Cálculo de salários

## Regras

* Todo e qualquer código deve ter seu teste equivalente (classe para testar o código)
>Exemplo: Classe Conta tem que ter uma ContaTeste que realize os testes nela
* Respeite as convenções de código
(https://www.oracle.com/technetwork/java/codeconventions-150003.pdf)
* Estruture o projeto com pacotes, conforme exemplo
> Nome do Projeto: Laboratorio2_Cinema
pacote1\
Classe1
Classe2
pacote2\
Classe3
Classe4

Importante:
*Atividade desenvolvida em duplas
* Atividade a ser entregue no ambiente EAD
* Formato de entrega: Arquivo ZIP dos códigos (sugestão de nome:
Lab3_NomeAluno1_NomeAluno2.zip)

![image](https://user-images.githubusercontent.com/129802487/229644282-d3522731-6de9-45e9-be9c-f6c8b1665bd6.png)

![image](https://user-images.githubusercontent.com/129802487/229644330-ba54e2f1-2344-4048-ba6f-45b48d5cbbd8.png)

Escrever um programa Java que realize a computação da folha de pagamentos de uma empresa. Nesta
empresa, os funcionários que são comissionados recebem uma porcentagem de suas vendas
(FuncionarioComissionadoTest), enquanto funcionários comissionados com salário base recebem o salário base
mais um percentual de suas vendas (FuncionarioComissionadoBaseSalario).

O cálculo dos rendimentos para o FuncionarioComissionadoTest é feito pela comissão X o percentual de
vendas. Para FuncionarioComissionadoBaseSalario, usa-se também o salário base + (comissão X o
percentual de vendas).

O FuncionarioAssalariado possui um salário semanal. Para o FuncionarioHorista, a regra do cálculo de
salário é: Se as horas trabalhadas na semana for menor que 40, salário por hora X horas trabalhadas na
semana. Se for mais que 40 horas, 40 X salário por hora + (horas trabalhada – 40) X salário por hora X 1,5.

Usem dos conceitos OO para organizar o projeto. Neste sentido, procure estruturar a hierarquia de classes,
aproveitando atributos e métodos. Métodos get/set foram suprimidos. Vocês podem complementar os
atributos, conforme a necessidade.
Pode simular vários empregados nos testes, com situações distintas. Também não esqueçam de usar as boas
práticas de programação discutidas em aula e os testes para cada tipo de funcionário.
