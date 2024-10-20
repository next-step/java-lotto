package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.*;

public class LottoController {

    public void play() {

        int money = InputView.getMoney();

        Money userMoney = new Money();
        int amount = userMoney.calculateLottoAmount(money);
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

        double winningRate = win.calculateWinningRate(money, totalWinningAmount);
        ResultView.printWinningRate(winningRate);
    }
}
