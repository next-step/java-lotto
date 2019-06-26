package com.java.lotto;

import com.java.lotto.domain.Lotto;
import com.java.lotto.domain.LottoNumbersGenerator;
import com.java.lotto.view.InputView;
import com.java.lotto.view.ResultView;

public class LottoMain {

    public static void main(String[] args) {

        int purchaseAmount = InputView.purchaseAmount();
        Lotto lotto = new Lotto(purchaseAmount);
        ResultView.outputOfPurchaseList(lotto);

        String winningNumbers = InputView.winningNumber();
        lotto.findLottoWinning(LottoNumbersGenerator.manualNumbersGenerator(winningNumbers));
        ResultView.outputOfWinStats(lotto);

    }
}
