package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        ContaController contas = new ContaController();

        int opcao, numero, agencia, tipo, aniversario;
        String titular;
        float saldo, limite;

        System.out.println("\nCriar Contas\n");

        ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000f, 100.0f);
        contas.cadastrar(cc1);

        ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 124, 1, "Maria da Silva", 2000f, 100.0f);
        contas.cadastrar(cc2);

        ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 125, 1, "Mariana dos Santos", 4000f, 12);
        contas.cadastrar(cp1);

        ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 126, 1, "Juliana Ramos", 8000f, 15);
        contas.cadastrar(cp2);

        while (true) {
            System.out.print(Cores.TEXT_PURPLE + Cores.ANSI_BLACK_BACKGROUND);
            System.out.println("*************************************************");
            System.out.println("                                                 ");
            System.out.println("              BANCO DO BRAZIL COM Z              ");
            System.out.println("                                                 ");
            System.out.println("*************************************************");
            System.out.println("                                                 ");
            System.out.println("          1 - Criar conta                        ");
            System.out.println("          2 - Listar todas as contas             ");
            System.out.println("          3 - Buscar conta por número            ");
            System.out.println("          4 - Atualizar dados da conta           ");
            System.out.println("          5 - Apagar conta                       ");
            System.out.println("          6 - Sacar                              ");
            System.out.println("          7 - Depositar                          ");
            System.out.println("          8 - Transferir valor entre contas      ");
            System.out.println("          9 - Sair                               ");
            System.out.println("                                                 ");
            System.out.println("*************************************************");
            System.out.print("Entre com a opção desejada: ");
            System.out.println("                     " + Cores.TEXT_RESET);

            try {
                opcao = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\nDigite valores inteiros!");
                scanner.nextLine();
                opcao = 0;
            }

            if (opcao == 9) {
                System.out.println(Cores.TEXT_WHITE_BOLD + "\nBanco do Brazil com Z - O seu Futuro começa aqui!");
                scanner.close();
                System.exit(0);
            }

            switch (opcao) {
                case 1:
                    System.out.println();
                    System.out.println(Cores.TEXT_WHITE_BOLD + "Criar Conta\n\n");

                    System.out.println("Digite o Número da Agência: ");
                    agencia = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea pendiente

                    System.out.println("Digite o Nome do Titular: ");
                    titular = scanner.nextLine();

                    do {
                        System.out.println("Digite o Tipo da Conta (1-CC ou 2-CP): ");
                        tipo = scanner.nextInt();
                    } while (tipo < 1 || tipo > 2);

                    System.out.println("Digite o Saldo da Conta (R$): ");
                    saldo = scanner.nextFloat();

                    switch (tipo) {
                        case 1:
                            System.out.println("Digite o Limite de Crédito (R$): ");
                            limite = scanner.nextFloat();
                            contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
                            break;
                        case 2:
                            System.out.println("Digite o dia do Aniversário da Conta");
                            aniversario = scanner.nextInt();
                            contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
                            break;
                        default:
                            System.out.println("Tipo de Conta Inválido!");
                            break;
                    }

                    keyPress();
                    break;
                case 2:
                    System.out.println();
                    System.out.println(Cores.TEXT_WHITE_BOLD + "Listar todas as Contas\n\n");
                    contas.listarTodas();
                    keyPress();
                    break;
                case 3:
                    System.out.println();
                    System.out.println(Cores.TEXT_WHITE_BOLD + "Consultar dados da Conta - por número\n\n");
                    System.out.println("Digite o número da conta: ");
                    numero = scanner.nextInt();
                    contas.procurarPorNumero(numero);
                    keyPress();
                    break;
                case 4:
                    System.out.println();
                    System.out.println(Cores.TEXT_WHITE_BOLD + "Atualizar Dados da Conta\n\n");

                    System.out.println("Digite o Número da conta: ");
                    numero = scanner.nextInt();

                    if (contas.buscarNaCollection(numero) != null) {
                        agencia = scanner.nextInt(); // Cambiado a nextInt() para agencia
                        scanner.nextLine(); // Consumir la nueva línea pendiente

                        System.out.println("Digite o Nome do Titular: ");
                        titular = scanner.nextLine();

                        System.out.println("Digite o Saldo da Conta: ");
                        saldo = scanner.nextFloat();

                        tipo = contas.retornaTipo(numero);

                        switch (tipo) {
                            case 1:
                                System.out.println("Digite o Limite de Crédito (R$): ");
                                limite = scanner.nextFloat();
                                contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
                                break;
                            case 2:
                                System.out.println("Digite o dia do Aniversário da Conta");
                                aniversario = scanner.nextInt();
                                contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
                                break;
                            default:
                                System.out.println("Tipo de Conta Inválido!");
                                break;
                        }
                    } else {
                        System.out.println("Conta não encontrada!");
                    }

                    keyPress();
                    break;
                case 5:
                    System.out.println();
                    System.out.println(Cores.TEXT_WHITE_BOLD + "Apagar a Conta\n\n");
                    System.out.println("Digite o número da conta: ");
                    numero = scanner.nextInt();

                    contas.deletar(numero);

                    keyPress();
                    break;
                case 6:
                    System.out.println();
                    System.out.println(Cores.TEXT_WHITE_BOLD + "Saque\n\n");
                    // Implementa la lógica de saque aquí
                    keyPress();
                    break;
                case 7:
                    System.out.println();
                    System.out.println(Cores.TEXT_WHITE_BOLD + "Depósito\n\n");
                    // Implementa la lógica de depósito aquí
                    keyPress();
                    break;
                case 8:
                    System.out.println();
                    System.out.println(Cores.TEXT_WHITE_BOLD + "Transferência entre Contas\n\n");
                    // Implementa la lógica de transferencia aquí
                    keyPress();
                    break;
                default:
                    System.out.println();
                    System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n");
                    keyPress();
                    break;
            }
        }
    }

    public static void keyPress() {
        try {
            System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
            System.in.read();
        } catch (IOException e) {
            System.out.println("Você pressionou uma tecla diferente de enter!");
        }
    }
}
