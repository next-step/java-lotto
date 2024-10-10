package lotto;

import lotto.config.GameConfig;
import lotto.io.ConsoleInputHandler;
import lotto.io.ConsoleOutputHandler;

public class GameApplication {

    public static void main(String[] args) {
        GameConfig gameConfig = new GameConfig(
                new ConsoleInputHandler(),
                new ConsoleOutputHandler(),
                1_000
        );
        Lotto lotto = new Lotto(gameConfig);
        lotto.run();
    }
}
