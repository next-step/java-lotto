package lotto.controller;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoMoney;
import lotto.domain.WinningPrize;
import lotto.service.LottoService;
import lotto.util.WinningUtils;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
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
        List<Integer> winningNumbersList = new ArrayList<>(winningNumbers);
        int bonusBall = InputView.getBonusBall();
        winningNumbersList.add(bonusBall);
        int totalWinningAmount = lottoService.getTotalWinningAmount(userLottos, winningNumbersList);
        ResultView.printResult();

        printResults(moneyAmount, totalWinningAmount);
    }

    private void printResults(int moneyAmount, int totalWinningAmount) {
        Map<WinningPrize, Integer> winningResults = lottoService.calculateWinningResults();
        ResultView.printWinningResults(winningResults);

        double winningRate = WinningUtils.calculateWinningRate(moneyAmount, totalWinningAmount);
        ResultView.printWinningRate(winningRate);
    }
}
