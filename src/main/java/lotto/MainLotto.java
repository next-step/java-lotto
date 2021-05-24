package lotto;

import lotto.domain.LottoGame;

import java.io.IOException;

public class MainLotto {

    public static void main(String[] args) throws IOException {
        LottoGame game = new LottoGame(null);
        game.start();
    }

}
