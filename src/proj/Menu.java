package proj;

import java.util.Scanner;

public class Menu {
    private static World world;

    // Important that the object is not shared. If we copied, we would have to return a modified world.
    public Menu(World world) { Menu.world = world; }

    private final static Scanner input = new Scanner(System.in);


    public static class CriadorEquipas {
        static Equipa equipa = getEquipaComNome();

        public static class SingleInput {

            @SuppressWarnings("SpellCheckingInspection")
            public static int getEscolhaPosicao() {
                System.out.println("Qual a posição que desejas?");
                System.out.println("1.) Avançado ");
                System.out.println("2.) Defesa");
                System.out.println("3.) Lateral");
                System.out.println("4.) Médio");
                System.out.println("5.) Guarda-redes");
                return input.nextInt();
            }

            public static String getNomeGuardaRedes() {
                System.out.print("Nome do guarda-redes: ");
                return input.nextLine();
            }

            public static String getNomeJogador() {
                System.out.println("Nome do jogador: ");
                return input.nextLine();
            }

            public static String getNomeEquipa() {
                System.out.print("Nome da equipa: ");
                return input.nextLine();
            }
        }

        public static Jogador getJogador(int numeroC) {
            int escolha;
            String nomeJ;
            while (true) {
                escolha = SingleInput.getEscolhaPosicao();
                nomeJ = SingleInput.getNomeJogador();
                if (escolha == 1) return new Avancado(nomeJ, numeroC);
                else if (escolha == 2) return new Defesa(nomeJ, numeroC);
                else if (escolha == 3) return new Lateral(nomeJ, numeroC);
                else if (escolha == 4) return new Medio(nomeJ, numeroC);
                else if (escolha == 5) return new GuardaRedes(nomeJ, numeroC);
                else System.out.println("Opção não disponível");
            }
        }

        public static Equipa getEquipaComNome() {
            String nomeEquipa;
            while (true) {
                nomeEquipa = SingleInput.getNomeEquipa();
                if (world.nomeEquipaEstaDisponivel(nomeEquipa)) { return new Equipa(nomeEquipa); }
                else { System.out.println("Equipa já existe"); }
            }
        }


        public static void criarEquipa() {
            System.out.println("Uma equipa é composta por, no mínimo, 14 jogadores. Prepare-se para criar sua equipa.");
            try { equipa.insereJogador(new GuardaRedes(SingleInput.getNomeGuardaRedes(), 1)); }
            catch (EquipaExcedeuNumeroMaximoDeJogadoresException | EquipaJaTemJogadorComEsseNumeroDeCamisaException e) { e.printStackTrace(); }
            for (int i = 2; i <= 14; i++) {
                try { equipa.insereJogador(getJogador(i)); }
                catch (EquipaExcedeuNumeroMaximoDeJogadoresException | EquipaJaTemJogadorComEsseNumeroDeCamisaException e) { e.printStackTrace(); }
            }

            if (equipa.numeroJogadores() == 23) {System.out.println("Equipa atingiu 23 jogadores");}
            try { world.insereEquipa(equipa); }
            catch (EquipaComEsseNomeJaExisteException | EquipaNaoTemGoleiroException | EquipaNaoTemNumeroMinimoDeJogadoresException e) {
                e.printStackTrace();
            }
        }
    }

    public static void consultarEquipa() {
        System.out.println("O que desejas fazer?");
        System.out.println("1.) Listar jogadores");
        System.out.println("2.) Calcular habilidade");

    }

    public static void start() {
        int choice;
        while (true) {
            System.out.println("Football Manager Main Menu\n");
            System.out.println("0.) Salvar estado");
            System.out.println("1.) Criar equipa"); // Players are also registered during this step
            System.out.println("2.) Consultar equipa"); // Consultar jogador aqui dentro?
            System.out.println("3.) Realizar jogo");
            System.out.println("4.) ");
            System.out.println("-1.) Exit");
            System.out.print("\nEscolha sua opção: ");

            choice = input.nextInt();


            switch (choice) {
                case 1 -> CriadorEquipas.criarEquipa();
                default -> System.out.println("This is not a valid Menu Option! Please Select Another");
            }
        }
    }
}
