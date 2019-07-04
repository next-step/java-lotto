package com.java.lotto;

import com.java.lotto.domain.Lotto;
import com.java.lotto.domain.LottoNumbersGenerator;
import com.java.lotto.view.InputView;
import com.java.lotto.view.ResultView;

public class LottoMain {

    public static void main(String[] args) {

        Lotto lotto = new Lotto(InputView.purchaseAmount());
        ResultView.outputOfPurchaseList(lotto);

        String winningNumbers = InputView.winningNumbers();
        int bonusNumber = InputView.bonusNumber();

        lotto.winningNumbers(winningNumbers, bonusNumber);
        ResultView.outputOfWinStats(lotto);

    }
}
