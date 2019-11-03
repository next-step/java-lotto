package step2;

import java.util.Set;

public class Game {
    private Set<Integer> game;

    public Game(int i) {
        this.game = Lotto.getUniques(i);
    }

    public int score(Set<Integer> lotto) {
        return game.stream().filter(lotto::contains).toArray().length;
    }
}
