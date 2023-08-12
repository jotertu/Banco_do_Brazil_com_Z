package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {
	
	public static Scanner scanner = new Scanner(System.in);
	
    public static void main(String[] args) {
    	
        int opcao = 0;
        
    	//* Teste da Classe Conta
        Conta c1 = new Conta(1, 123, 1, "Adriana", 10000.0f);
        c1.visualizar();
        c1.sacar(12000.0f);
        c1.visualizar();
        c1.depositar(5000.0f);
        c1.visualizar();
        
        //Teste da classe Conta Corrente
        ContaCorrente cc1 = new ContaCorrente(2, 123, 1, "Mariana", 15000.0f, 1000.0f);
        cc1.visualizar();
        cc1.sacar(12000.0f);
        cc1.visualizar();
        cc1.depositar(5000.0f);
        cc1.visualizar();
        
        //Teste da Classe Conta Corrente
        ContaPoupanca cp1 = new ContaPoupanca(3, 123, 2, "Victor", 100000.0f, 15);
        cp1.visualizar();
        cp1.sacar(1000.0f);
		cp1.visualizar();
		cp1.depositar(5000.0f);
		cp1.visualizar();

        while (true) {
        	
            System.out.print(Cores.TEXT_PURPLE + Cores.ANSI_BLACK_BACKGROUND
            				  +"*************************************************");
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
            System.out.print  ("Entre com a opção desejada: ");
            System.out.println("                     "+ Cores.TEXT_RESET);
            
            try {
				opcao = scanner.nextInt();
			}catch(InputMismatchException e){
				System.out.println("\nDigite valores inteiros!");
				scanner.nextLine();
				opcao=0;
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
                    keyPress();
                    break;
                case 2:
                    System.out.println();
                    System.out.println(Cores.TEXT_WHITE_BOLD + "Listar todas as Contas\n\n");
                    keyPress();
                    break;
                case 3:
                    System.out.println();
                    System.out.println(Cores.TEXT_WHITE_BOLD + "Consultar dados da Conta - por número\n\n");
                    keyPress();
                    break;
                case 4:
                    System.out.println();
                    System.out.println(Cores.TEXT_WHITE_BOLD + "Atualizar dados da Conta\n\n");
                    keyPress();
                    break;
                case 5:
                    System.out.println();
                    System.out.println(Cores.TEXT_WHITE_BOLD + "Apagar a Conta\n\n");
                    keyPress();
                    break;
                case 6:
                    System.out.println();
                    System.out.println(Cores.TEXT_WHITE_BOLD + "Saque\n\n");
                    keyPress();
                    break;
                case 7:
                    System.out.println();
                    System.out.println(Cores.TEXT_WHITE_BOLD + "Depósito\n\n");
                    keyPress();
                    break;
                case 8:
                    System.out.println();
                    System.out.println(Cores.TEXT_WHITE_BOLD + "Transferência entre Contas\n\n");
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
		
		} catch(IOException e) {
			
			System.out.println("Você pressionou uma tecla diferente de enter!");
		}
		
	}
    
}
