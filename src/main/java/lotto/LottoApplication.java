package lotto;

import lotto.controller.GameController;

public class LottoApplication {
    public static void main(String[] args) {
        new LottoApplication().run(args);
    }

    private void run(String[] args) {
        GameController gameController = new GameController();
        gameController.start();
    }
}
