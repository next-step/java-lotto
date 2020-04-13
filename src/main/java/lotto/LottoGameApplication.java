package lotto;

import lotto.domain.LottoGame;
import lotto.ui.InputView;

public class LottoGameApplication {

    //    LottoGame lottoGame = new LottoGame();
    public static void main(String[] args) {
        long money = InputView.inputMoney();
        LottoGame.buy(money);
    }
}
