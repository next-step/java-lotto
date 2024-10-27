package lotto.controller;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoMoney;
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
        Map<Integer, Integer> matchCountMap = lottoService.initializeMatchCountMap();

        int totalWinningAmount = lottoService.getTotalWinningAmount(userLottos, winningNumbers, matchCountMap);
        ResultView.printResult();

        printResults(matchCountMap, moneyAmount, totalWinningAmount);
    }

    private static void printResults(Map<Integer, Integer> matchCountMap, int moneyAmount, int totalWinningAmount) {
        for (int matchCount : matchCountMap.keySet()) {
            int prizeMoney = WinningUtils.getPrizeMoney(matchCount);
            int count = matchCountMap.get(matchCount);
            ResultView.printMatchCount(matchCount, prizeMoney, count);
        }

        double winningRate = WinningUtils.calculateWinningRate(moneyAmount, totalWinningAmount);
        ResultView.printWinningRate(winningRate);
    }

}
