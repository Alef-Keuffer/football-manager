package proj;

import java.util.Map;

public class World {
    private Map<String, Equipa> equipas;

    public void insereEquipa(Equipa equipa) throws EquipaComEsseNomeJaExisteException, EquipaNaoTemGoleiroException, EquipaNaoTemNumeroMinimoDeJogadoresException {
        if (equipas.containsKey(equipa.getNome())) {throw new EquipaComEsseNomeJaExisteException();}
        if (!equipa.temGuardaRedes()) {throw new EquipaNaoTemGoleiroException();}
        if(equipa.numeroJogadores() <= CONSTANTS.MIN_NO_PLAYERS) {throw new EquipaNaoTemNumeroMinimoDeJogadoresException();}
        this.equipas.put(equipa.getNome(), equipa);

    }

    public boolean nomeEquipaEstaDisponivel(String nomeEquipa) { return equipas.containsKey(nomeEquipa); }
}
