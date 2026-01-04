package org.example;

public class Poupanca implements InterfacePoupanca {
    private double saldoAtual = 0.0;
    @Override
    public boolean sacar(double valor) {

        if (valor > saldoAtual || valor <= 0) {
            System.out.println("Saldo inválido ou insuficiente para saque");
            return false;
        }
        else {
            saldoAtual -= valor;
            System.out.println("Saque realizado com sucesso no valor de R$" + valor);
            return true;
        }
    }

    @Override
    public boolean depositar( double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido para depósito!");
            return false;
        } else {
            saldoAtual += valor;
            System.out.println("Depósito realizado com sucesso no valor de R$" + valor);
            return true;
        }
    }

    public double getSaldoAtual() {
        return saldoAtual;
    }

    @Override
    public void aplicarRendimento(int escolha) {
        switch (escolha){
            case 1:
                System.out.println("Tipo de rendimento escolhido: Alfa. Projeção de rendimentos para o próximo mês: R$" + (saldoAtual * 0.012 + saldoAtual));
                break;
            case 2:
                System.out.println("Tipo de rendimento escolhido: Gama. Projeção de rendimentos para o próximo mês: R$" + (saldoAtual * 0.015 + saldoAtual));
                break;
            default:
                System.out.println("Opção inválida");
        }}}