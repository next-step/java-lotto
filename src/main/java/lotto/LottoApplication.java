package lotto;

import common.view.LottoInputView;
import lotto.controller.LottoGame;

public class LottoApplication {
    public static void main(String[] args) {
        int amount = LottoInputView.requestPurchaseAmount();

        LottoGame lottoGame = new LottoGame(amount);
        lottoGame.playGame();
    }
}
