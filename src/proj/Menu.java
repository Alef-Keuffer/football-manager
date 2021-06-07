package proj;

import java.util.Scanner;

public class Menu {
    private final static Scanner input = new Scanner(System.in);

    public static void criar_equipa(){

    }

    public static void start() {
        int choice;
        while (true) {
            System.out.println("Football Manager Main Menu\n");
            System.out.println("1.) Criar equipa");
            System.out.println("2.) Criar equipa");
            System.out.println("3.) Associar jogador a uma equipa");
            System.out.println("4.) Consultar jogador");
            System.out.println("5.) Consultar equipa");
            System.out.println("-1.) Exit");
            System.out.print("\nEnter Your Menu Choice: ");

            choice = input.nextInt();


            switch (choice) {

                case 1: // Criar equipa
                    int adNumf, adNuml, sum;
                    String nome_da_equipa;
                    System.out.print("Nome da equipa: ");
                    nome_da_equipa = input.nextLine();
                    adNumf = input.nextInt();
                    System.out.print("\nPlease Enter The Second Number: ");
                    adNuml = input.nextInt();
                    sum = adNumf + adNuml;
                    System.out.print("The Sum Of Those Numbers is: " + sum);
                    break;

                case 2: // Criar equipa
                    int subNum1, subNum2, sum2;
                    System.out.println("\nPlease Enter The First Number: ");
                    subNum1 = input.nextInt();
                    System.out.println("Please Enter The Second Number: ");
                    subNum2 = input.nextInt();
                    sum2 = subNum1 - subNum2;
                    System.out.println("The Subtraction Leaves The Number: " + sum2);
                    break;

                case 3: // Associar jogador a uma equipa
                    int multNum1, multNum2, multTotal;

                    // Gather Input
                    System.out.println("Please Enter The First Number To Multiply: ");
                    multNum1 = input.nextInt();
                    System.out.println("Please Enter The Second Number To Multiply: ");
                    multNum2 = input.nextInt();

                    // This will Multiply the Numbers
                    multTotal = multNum1 * multNum2;

                    //Display Final
                    System.out.println("The Multiplied Numbers Are: " + multTotal);
                    break;

                case 4: // Consultar jogador
                    //Definitions
                    double divNum1, divNum2, divTotal;
                    System.out.println("Enter Your Numerator ");
                    divNum1 = input.nextInt();
                    System.out.println("Enter Your Denominator ");
                    divNum2 = input.nextInt();
                    if (divNum2 == 0) {
                        System.out.println("Zero is Not divisable, please select a new denominator: ");
                        divNum2 = input.nextInt();
                    }
                    divTotal = divNum1 / divNum2;
                    System.out.println("Your divisor is: " + divTotal);
                    break;

                case 5:
                    double limL, limH, rand;
                    System.out.println("Enter Your Low Limit: ");
                    limL = input.nextInt();
                    System.out.println("Enter Your High Limit ");
                    limH = input.nextInt();

                    //Equation to keep numbers within bounds
                    rand = limL + (Math.random() * ((limH - limL) + 1));
                    System.out.println("Given Your Limits, the Random Number will be: " + rand);
                    break;

                case -1:
                    System.out.println("Exiting Program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("This is not a valid Menu Option! Please Select Another");
                    break;

            }
        }
    }
}
