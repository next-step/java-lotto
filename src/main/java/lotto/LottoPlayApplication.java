package lotto;

import lotto.controller.LottoGame;

import java.util.Random;

public class LottoPlayApplication {
    public static void main (String [] arg) {
        Random random = new Random();

        LottoGame lottoGame = new LottoGame();
        lottoGame.start(random);
    }
}
