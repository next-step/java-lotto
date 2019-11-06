package com.seok2.lotto;

import com.seok2.lotto.domain.Lotteries;
import com.seok2.lotto.domain.LottoMachine;
import com.seok2.lotto.domain.Money;
import com.seok2.lotto.domain.Papers;
import com.seok2.lotto.domain.Ranks;
import com.seok2.lotto.view.LottoInputView;
import com.seok2.lotto.view.LottoOutputView;

public class LottoMain {

    public static void main(String[] args) {
        Money investment = LottoInputView.getInvestment();
        Papers papers = LottoInputView.getPapers(investment);
        Lotteries lotteries = LottoMachine.buy(investment, papers);
        LottoOutputView.print(lotteries);
        Ranks ranks = lotteries.check(LottoInputView.getWinning());
        LottoOutputView.print(ranks);
    }
}
