package lotto.controller;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoMoney;
import lotto.domain.WinningPrize;
import lotto.service.LottoService;
import lotto.util.WinningUtils;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Map;
import java.util.Set;


public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }


    public void play() {

        int moneyAmount = InputView.getMoney();
        LottoMoney money = new LottoMoney(moneyAmount);

        int amount = lottoService.calculateLottoAmount(money);
        ResultView.printLottoAmount(amount);

        List<LottoNumbers> userLottos = lottoService.generateLottoNumbers(amount);
        ResultView.printLottoNumbers(userLottos);

        Set<Integer> winningNumbers = InputView.getWinningNumbers();
        int bonusBall = InputView.getBonusBall();
        int totalWinningAmount = lottoService.getTotalWinningAmount(bonusBall, userLottos, winningNumbers);
        ResultView.printResult();

        int[] matchCount = lottoService.getMatchCount();
        printResults(moneyAmount, totalWinningAmount, matchCount);
    }

    private void printResults(int moneyAmount, int totalWinningAmount, int[] matchCount) {
        for (WinningPrize prize : WinningPrize.values()) {
            int prizeMoney = prize.getPrizeMoney();
            int count = matchCount[prize.ordinal()];
            ResultView.printMatchCount(prize.getMatchCount(), prizeMoney, count);
        }

        double winningRate = WinningUtils.calculateWinningRate(moneyAmount, totalWinningAmount);
        ResultView.printWinningRate(winningRate);
    }

}
