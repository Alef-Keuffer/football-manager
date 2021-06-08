package proj;

import java.util.ArrayList;
import java.util.List;

public class Equipa {

    private String nome;
    private List<Jogador> jogadores;

    public Equipa(String nomeE) {
        nome = nomeE;
        jogadores = new ArrayList<>();
    }

    public int numeroJogadores() { return jogadores.size(); }

    public static Equipa parse(String input) {
        String[] campos = input.split(",");
        return new Equipa(campos[0]);
    }

    public void insereJogador(Jogador j) throws EquipaExcedeuNumeroMaximoDeJogadoresException, EquipaJaTemJogadorComEsseNumeroDeCamisaException {
        if (numeroJogadores() > CONSTANTS.MAX_NO_PLAYERS) throw new EquipaExcedeuNumeroMaximoDeJogadoresException();
        if (jogadores.stream().anyMatch(jog -> jog.getNumeroJogador() == j.getNumeroJogador()))
        {throw new EquipaJaTemJogadorComEsseNumeroDeCamisaException();}
        jogadores.add(j.clone()); }

    public boolean temGuardaRedes(){
        return jogadores.stream().anyMatch(j-> j.getClass() == GuardaRedes.class);
    }

    public String getNome() { return nome; }

    public String toString() {
        StringBuilder r = new StringBuilder("Equipa:" + nome + "\n");
        for (Jogador j : jogadores) {
            r.append(j.toString());
        }
        return r.toString();
    }

}


