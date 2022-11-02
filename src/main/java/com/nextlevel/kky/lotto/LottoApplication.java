package com.nextlevel.kky.lotto;

import java.util.List;

public class LottoApplication {

    public static void main(String[] arg) {
        LottoService lottoService = new LottoService(new LottoIntegerArrayGenerator());

        int amount = InputView.inputAmount();
        List<List<Integer>> lottoList = lottoService.buyLotto(amount);
        ResultView.printBoughtLotto(lottoList);

        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        WinningStatistics winningStatistics = lottoService.calculateWinningStatistics(winningNumbers, lottoList);
        ResultView.printWinningStatistics(winningStatistics);
    }
}
