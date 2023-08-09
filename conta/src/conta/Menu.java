package conta;

import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int opcao;

        while (true) {

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
            System.out.print  ("Entre com a opção desejada: "                     );
            System.out.println("                                                 ");

            opcao = scanner.nextInt();

            if (opcao == 9) {
                System.out.println("\nBanco do Brazil com Z - O seu Futuro começa aqui!");
                scanner.close();
                System.exit(0);
            }

            switch (opcao) {
                case 1:
                    System.out.println("Criar Conta\n\n");
                    break;

                case 2:
                    System.out.println("Listar todas as Contas\n\n");
                    break;

                case 3:
                    System.out.println("Consultar dados da Conta - por número\n\n");
                    break;

                case 4:
                    System.out.println("Atualizar dados da Conta\n\n");
                    break;

                case 5:
                    System.out.println("Apagar a Conta\n\n");
                    break;

                case 6:
                    System.out.println("Saque\n\n");
                    break;

                case 7:
                    System.out.println("Depósito\n\n");
                    break;

                case 8:
                    System.out.println("Transferência entre Contas\n\n");
                    break;

                default:
                    System.out.println("\nOpção Inválida!\n");
                    break;
            }

        }
    }
}
