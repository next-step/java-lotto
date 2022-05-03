package lotto;

import lotto.controller.GameController;

public class LottoApplication {
    public static void main(String[] args) {
        LottoApplication.run(args);
    }

    private static void run(String[] args) {
        GameController gameController = new GameController();
        gameController.start();
    }
}
