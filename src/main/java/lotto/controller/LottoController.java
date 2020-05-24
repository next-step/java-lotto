package lotto.controller;

import lotto.domain.LottoShop;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class LottoController {

    public ResultView purchaseLotto() {
        int inputMoney = InputView.inputMoney();

        ResultView resultView = new ResultView();

        return resultView;
    }
}
