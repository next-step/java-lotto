package com.lotto.controller;

import com.lotto.model.Money;
import com.lotto.model.UserLottos;
import com.lotto.model.WinningLotto;
import com.lotto.view.LottoInputView;
import com.lotto.view.LottoResultView;

public class LottoMain {

    public static void main(String[] args) {
        LottoInputView lottoInputView = new LottoInputView();
        int money = lottoInputView.inputPurhaseAmount();
        UserLottos userLottos = new UserLottos(new Money(money));

        LottoResultView lottoResultView = new LottoResultView(userLottos);
        lottoResultView.printUserLottos();

        WinningLotto winningLotto = lottoInputView.inputWinningNumbers();
        lottoResultView.printWinningRate(winningLotto, money);
    }
}
