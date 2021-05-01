package Data.Stateful;

import Data.Attribute;
import Data.Position;

import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

record PLAYER_CONSTANTS(int ATTRIBUTE_MAX, int ATTRIBUTE_INITIAL_MIN, int ATTRIBUTE_INITIAL_MAX) {}

public class Player {

    // Think about how to differentiate two players with the same name
    // and in the same team and so on.
    private static final PLAYER_CONSTANTS CONSTANTS = new PLAYER_CONSTANTS(10, 1, 3);
    public final UUID id = UUID.randomUUID();
    private final Random generator = new Random(id.getMostSignificantBits());
    String name;
    HashMap<Attribute, Double> attributes = initialAttributes();
    String team;
    Position position;

    // This will be the value of the player, like the total power
    public double weight() {
        return attributes.values().stream()
                         .mapToDouble(x -> x * (1 + generator.nextDouble()))
                         .sum() // Think of it as the player's bonuses, natural talent, etc
                + new Random(team.hashCode()).nextDouble() * CONSTANTS.ATTRIBUTE_MAX(); // synergy when on a certain
        // team
    }

    private HashMap<Attribute, Double> initialAttributes() {
        HashMap<Attribute, Double> initialAttributes = new HashMap<>();
        for (Attribute a : Attribute.values())
            initialAttributes.put(a, generator.nextDouble());
        return initialAttributes;
    }

    public Player(String name) {
        this.name = name;
    }
}
