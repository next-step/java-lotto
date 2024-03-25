package lotto;

import lotto.controller.LottoGame;
import lotto.domain.LottoStore;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame(new InputView(), new ResultView(), new LottoStore());
        lottoGame.start();
    }
}
