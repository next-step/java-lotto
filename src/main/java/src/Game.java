package src;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private static final int LOTTO_NUMBER_SIZE = 45;

    private static final int GAME_NUMBER_SIZE = 6;

    private static final List<Integer> lottoNumbers = new ArrayList<>(LOTTO_NUMBER_SIZE);

    static {
        for (int idx = 1; idx <= LOTTO_NUMBER_SIZE; idx++) {
            lottoNumbers.add(idx);
        }
    }

    private final List<Integer> numbers = new ArrayList<>(GAME_NUMBER_SIZE);

    public static Game newGame() {
        Game game = new Game();
        for (int idx = 0; idx< GAME_NUMBER_SIZE; idx++) {
            game.numbers.add(lottoNumbers.get(0));
        }

        return game;
    }

    public int numberSize() {
        return numbers.size();
    }
}
