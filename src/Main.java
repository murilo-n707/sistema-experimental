package org.example;

import module java.base;



public class Main {

    public static void limparConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            for (int i = 0; i < 50; i++) System.out.println();
        }
    }
    static void main() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                =========================\s
                Bem Vindo ao banco Yale
                =========================\s
                Primeiro, escolha o tipo de conta a ser aberto:\s
                1. Conta Corrente\s
                2. Conta Poupança\s
                =========================""");

        int escolha = scanner.nextInt();

        limparConsole();

        while (escolha != 1 && escolha != 2) {
            System.out.println("""
                    Opção inválida! Escolha uma das opções abaixo:\s
                    1. Conta Corrente\s
                    2. Conta Poupança\s
                    """);
            escolha = scanner.nextInt();

            limparConsole();
        }


        Poupanca p = null;
        Corrente c = null;

        switch (escolha) {

            case 1:
                c = new Corrente();
                System.out.println("Conta Corrente criada com sucesso!");
                break;
            case 2:
                p = new Poupanca();
                System.out.println("Conta Poupança criada com sucesso!");
                break;

        }
        int menu;
        do {
            if (escolha == 1) {
                System.out.println("""
                        \s
                        <=====MENU======>\s
                        Escolha uma das opções abaixo:\s
                        1. Depositar\s
                        2. Sacar\s
                        3. Consultar Saldo\s
                        0. Sair do sistema
                        <===============>""");
                menu = scanner.nextInt();
                limparConsole();
            } else {
                System.out.println("""
                        \s
                        <======MENU=====>
                        Escolha uma das opções abaixo:\s
                        1. Depositar\s
                        2. Sacar\s
                        3. Consultar Saldo\s
                        4. Alterar plano de rendimento\s
                        0. Sair do sistema
                        """);
                menu = scanner.nextInt();
                limparConsole();
            }
            switch (menu) {
                case 1:
                    System.out.println("Digite o valor a ser depositado:");
                    double valor_dep = scanner.nextDouble();
                    if (escolha == 1) {
                        c.depositar(valor_dep);
                    } else {
                        p.depositar(valor_dep);
                    }
                    break;
                case 2:
                    System.out.println("Digite o valor a ser sacado:");
                    double valor_saque = scanner.nextDouble();
                    if (escolha == 1) {
                        c.sacar(valor_saque);
                    } else {
                        p.sacar(valor_saque);
                    }
                    break;
                case 3:
                    if (escolha == 1) {
                        System.out.println("O seu saldo atual é de:" + c.getSaldoAtual());
                    } else {
                        System.out.println("O seu saldo atual é de:" + p.getSaldoAtual());
                    }
                    break;
                case 4:
                    if (escolha == 2) {
                        System.out.println("""
                                Escolha o novo plano de rendimento:
                                1.Alfa (1.2%)
                                2.Gama (1.5%)
                                """);
                        int plano = scanner.nextInt();
                        p.aplicarRendimento(plano);
                    } else {
                        System.out.println("Opção inválida");
                    }
                    break;

                case 0:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção inexistente!");
                    limparConsole();
            }
        } while (menu != 0);
        scanner.close();


    }
}