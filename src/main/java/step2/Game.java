package step2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Game {
    private Set<Integer> game;

    public Game(int max, int limit) {
        UserNumbers userNumbers = new UserNumbers(1, max);
        this.game = userNumbers.getUniques(limit);
    }

    public static List<Game> buy(int amount, int max, int limit) {
        List<Game> games = new ArrayList<>();
        for (int count = 0; count < amount; count++) {
            games.add(new Game(max, limit));
        }
        return games;
    }

    public String gameNumbers() {
        return "[" + game.stream().sorted().map(String::valueOf).reduce((o1, o2) -> o1 + ", " + o2).get() + "]";
    }

    public int score(Set<Integer> lotto) {
        return game.stream().filter(lotto::contains).toArray().length;
    }
}
