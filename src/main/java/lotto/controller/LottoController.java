package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoMoney;
import lotto.domain.Win;
import lotto.domain.WinningPrize;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class LottoController {

    public void play() {

        int moneyAmount = InputView.getMoney();
        LottoMoney money = new LottoMoney(moneyAmount);

        int amount = money.calculateLottoAmount();
        ResultView.printLottoAmount(amount);

        Lotto lotto = new Lotto();
        Win win = new Win();

        List<LottoNumbers> userLottos = new ArrayList<>();

        for (int i = 1; i <= amount; i++) {
            LottoNumbers selectedNumbers = lotto.generateLotto();
            ResultView.printLottoNumbers(selectedNumbers);
            userLottos.add(selectedNumbers);
        }

        Set<Integer> winningNumbers = InputView.getWinningNumbers();

        Map<Integer, Integer> matchCountMap = new HashMap<>();
        for (WinningPrize prize : WinningPrize.values()) {
            matchCountMap.put(prize.getMatchCount(), 0);
        }

        int totalWinningAmount = 0;

        for (LottoNumbers userLotto : userLottos) {
            int matchCount = win.countMatchingNumbers(winningNumbers, userLotto);
            if (matchCount >= 3) {
                matchCountMap.put(matchCount, matchCountMap.get(matchCount) + 1);
                totalWinningAmount += win.getPrizeMoney(matchCount);
            }
        }

        ResultView.printResult();
        for (int matchCount : matchCountMap.keySet()) {
            int prizeMoney = win.getPrizeMoney(matchCount);
            int count = matchCountMap.get(matchCount);
            ResultView.printMatchCount(matchCount, prizeMoney, count);
        }

        double winningRate = win.calculateWinningRate(moneyAmount, totalWinningAmount);
        ResultView.printWinningRate(winningRate);
    }
}
