package com.nextlevel.kky.lotto;

import java.util.List;

public class LottoApplication {

    public static void main(String[] arg) {
        LottoService lottoService = new LottoService(new LottoIntegerArrayGenerator());

        int amount = InputView.inputAmount();
        List<Lotto> lottoList = lottoService.buyLotto(amount);
        ResultView.printBoughtLotto(lottoList);

        Lotto winningNumbers = new Lotto(InputView.inputWinningNumbers());
        WinningStatistics winningStatistics = lottoService.calculateWinningStatistics(winningNumbers, lottoList);
        ResultView.printWinningStatistics(winningStatistics);
    }
}
