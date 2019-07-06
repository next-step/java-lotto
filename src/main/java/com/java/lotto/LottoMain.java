package com.java.lotto;

import com.java.lotto.domain.*;
import com.java.lotto.view.InputView;
import com.java.lotto.view.ResultView;

import java.util.List;

public class LottoMain {

    public static void main(String[] args) {

        int purchaseAmount = InputView.purchaseAmount();
        List<String> manualLottoNumbers = InputView.inputOfManualLotto(InputView.countOfManualLotto());
        LottoPurchase lottoPurchase = new LottoPurchase(purchaseAmount, manualLottoNumbers);

        Lotto lotto = new Lotto(lottoPurchase);
        ResultView.outputOfPurchaseList(lotto);

        WinningTicket winningTicket = new WinningTicket(InputView.winningNumbers(), InputView.bonusNumber());
        WinningStatistics winningStatistics = new WinningStatistics(winningTicket, lotto);
        ResultView.outputOfWinStats(winningStatistics);

    }
}
