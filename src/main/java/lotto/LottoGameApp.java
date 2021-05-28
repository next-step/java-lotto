package lotto;

import lotto.view.GameView;

public class LottoGameApp {
    public static void main(String[] args) {
        boolean result = false;
        GameView gameView = new GameView();
        while(!result) {
            result = gameView.start();
        }

        gameView.finish();

    }
}
