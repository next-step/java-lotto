package lotto.controller;

import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {
    public static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {
        int numberOfLotto = InputView.inputMoney() / LOTTO_PRICE;
        Lotto lotto = new Lotto(numberOfLotto);
        ResultView.resultLottoNumber(numberOfLotto, lotto);

        String[] winningNumbers = InputView.inputWinningNumbers().split(",");
    }
}
