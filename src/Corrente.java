package org.example;

public class Corrente implements InterfaceCorrente {
    private double saldoAtual = 0.0;

    public double getSaldoAtual() {
        return saldoAtual;
    }

    @Override
    public boolean sacar(double valor) {

        if (valor > saldoAtual || valor <= 0) {
            System.out.println("Valor inválido para saque!");
            return false;
        }
        else {
            saldoAtual = saldoAtual - valor;
            System.out.println("Saque realizado com sucesso no valor de R$ " + valor);
            return true;
        }
    }

    @Override
    public boolean depositar(double valor) {

        if (valor <= 0) {
            System.out.println("Valor inválido para depósito!");
            return false;
        }
        else {
            saldoAtual = saldoAtual + valor;
            System.out.println("Depósito realizado com sucesso no valor de R$ " + valor);
            return true;

        }
    }
}