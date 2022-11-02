package com.nextlevel.kky.lotto;

import java.util.List;

public class LottoApplication {

    public static void main(String[] arg) {
        LottoShop lottoShop = new LottoShop(new LottoIntegerArrayGenerator());

        int amount = InputView.inputAmount();
        List<Lotto> lottoList = lottoShop.buyLotto(amount);
        ResultView.printBoughtLotto(lottoList);

        Lotto winningNumbers = new Lotto(InputView.inputWinningNumbers());
        WinningStatistics winningStatistics = LotteryCommission.calculateWinningStatistics(winningNumbers, lottoList);
        ResultView.printWinningStatistics(winningStatistics);
    }
}
