package lotto;


import lotto.domain.LottoSeller;
import lotto.view.InputView;

public class LottoMain {
    public static void main(String[] args) {
        int money = InputView.inputMoney();
        String winLotto = InputView.inputWinLotto();

        LottoSeller lottoSeller = new LottoSeller(money);

    }
}
