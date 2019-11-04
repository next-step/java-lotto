package com.seok2.lotto;

import com.seok2.lotto.domain.*;
import com.seok2.lotto.view.LottoInputView;
import com.seok2.lotto.view.LottoOutputView;

public class LottoMain {

    public static void main(String[] args) {
        Money investment = LottoInputView.getMoney();
        Lotteries lotteries = LottoMachine.buy(investment.clone());
        LottoOutputView.printPurchaseHistory(lotteries);
        Lotto winning = LottoInputView.getWinning();
        GameStats stats = lotteries.check(winning);
        LottoOutputView.printStats(stats);
        LottoOutputView.printProfit(stats.getProfit(investment));
    }
}
