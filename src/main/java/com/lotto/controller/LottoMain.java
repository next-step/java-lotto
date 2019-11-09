package com.lotto.controller;

import com.lotto.model.WinningLotto;
import com.lotto.view.LottoInputView;

public class LottoMain {

    public static void main(String[] args) {
        LottoInputView lottoInputView = new LottoInputView();
        int money = lottoInputView.inputPurhaseAmount();

        WinningLotto winningLotto = lottoInputView.inputWinningNumbers();
    }
}
