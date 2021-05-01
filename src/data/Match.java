package data;

import data.stateful.Player;

public record Match(Team<Player> team1, Team<Player> team2) {}
