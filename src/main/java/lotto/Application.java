package lotto;

import lotto.controller.LottoGame;

public class Application {

    public static void main(String[] args) {
        LottoGame lottoGame = LottoGame.getInstance();
        lottoGame.play();
    }
}
