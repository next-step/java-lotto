package lotto;

import lotto.io.ConsoleInputHandler;
import lotto.io.ConsoleOutputHandler;

public class GameApplication {

    public static void main(String[] args) {
        Lotto lotto = new Lotto(new ConsoleInputHandler(), new ConsoleOutputHandler(), 1_000);
        lotto.run();
    }
}
