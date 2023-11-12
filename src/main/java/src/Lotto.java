package src;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    public static final int LOTTO_PRICE = 1000;

    private final List<Game> games;

    public Lotto(int gameCount) {
        this.games = new ArrayList<>(gameCount);
    }

    public static Lotto lotto(int gameCount) {
        Lotto lotto = new Lotto(gameCount);

        for (int idx = 0; idx < gameCount; idx++) {
            lotto.games.add(new Game());
        }

        return lotto;
    }

    public int gameCount() {
        return games.size();
    }
}
