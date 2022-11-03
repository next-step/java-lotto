package com.nextlevel.kky.lotto;

import com.nextlevel.kky.lotto.domain.LotteryCommission;
import com.nextlevel.kky.lotto.domain.LottoIntegerArrayGenerator;
import com.nextlevel.kky.lotto.domain.LottoShop;
import com.nextlevel.kky.lotto.model.Lotto;
import com.nextlevel.kky.lotto.model.WinningStatistics;
import com.nextlevel.kky.lotto.ui.InputView;
import com.nextlevel.kky.lotto.ui.ResultView;

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
