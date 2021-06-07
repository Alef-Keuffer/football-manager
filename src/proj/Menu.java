package proj;

import utils.function.Probability;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private static World world;

    // Important that the object is not shared. If we copied, we would have to return a modified world.
    public Menu(World world) { Menu.world = world; }

    private final static Scanner input = new Scanner(System.in);

    public static void criarEquipa() {
        String nomeEquipa;
        Equipa equipa;
        while (true){
            System.out.print("Nome da equipa: ");
            nomeEquipa = input.nextLine();
            if (!world.equipasMap.containsKey(nomeEquipa)){
                equipa = new Equipa(nomeEquipa);
                break;
            }
            System.out.println("Equipa já existe");
        }
        System.out.println("Uma equipa é composta por 23 jogadores. Prepare-se para criar sua equipa.");
        System.out.print("Nome do guarda-redes: ");
        String nomeGuardaRedes = input.nextLine();
        equipa.insereJogador(new GuardaRedes(nomeGuardaRedes, 1));
        for (int i = 1; i <= 23; i++) {
            System.out.println("Qual a posição que desejas?");
            System.out.println("1.) Avançado ");
            System.out.println("2.) Defesa");
            System.out.println("3.) Lateral");
            System.out.println("4.) Médio");
            System.out.println("5.) Guarda-redes");
            System.out.print("Nome do jogador: ");
            switch (input.nextInt()) {
                case 1 -> equipa.insereJogador(new Avancado(input.nextLine(), i));
                case 2 -> equipa.insereJogador(new Defesa(input.nextLine(), i));
                case 3 -> equipa.insereJogador(new Lateral(input.nextLine(), i));
                case 4 -> equipa.insereJogador(new Medio(input.nextLine(), i));
                case 5 -> equipa.insereJogador(new GuardaRedes(input.nextLine(), i));
                default -> {
                    System.out.println(i + " não é uma opção");
                    i--;
                }
            }
        }
        if (equipa.numeroJogadores() == 23) { world.equipas.add(equipa); }
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
                case 1 -> criarEquipa();
                case 2 -> { // Criar equipa
                    int subNum1, subNum2, sum2;
                    System.out.println("\nPlease Enter The First Number: ");
                    subNum1 = input.nextInt();
                    System.out.println("Please Enter The Second Number: ");
                    subNum2 = input.nextInt();
                    sum2 = subNum1 - subNum2;
                    System.out.println("The Subtraction Leaves The Number: " + sum2);
                }
                case 3 -> { // Associar jogador a uma equipa
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
                }
                case 4 -> { // Consultar jogador
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
                }
                case 5 -> {
                    double limL, limH, rand;
                    System.out.println("Enter Your Low Limit: ");
                    limL = input.nextInt();
                    System.out.println("Enter Your High Limit ");
                    limH = input.nextInt();

                    //Equation to keep numbers within bounds
                    rand = limL + (Math.random() * ((limH - limL) + 1));
                    System.out.println("Given Your Limits, the Random Number will be: " + rand);
                }
                case -1 -> {
                    System.out.println("Exiting Program...");
                    System.exit(0);
                }
                default -> System.out.println("This is not a valid Menu Option! Please Select Another");
            }
        }
    }
}
