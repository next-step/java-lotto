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

        int amount = calculateLottoAmount(money);
        List<LottoNumbers> userLottos = generateLottoNumbers(amount);

        Set<Integer> winningNumbers = InputView.getWinningNumbers();
        Map<Integer, Integer> matchCountMap = initializeMatchCountMap();

        int totalWinningAmount = getTotalWinningAmount(userLottos, winningNumbers, matchCountMap);
        printResults(matchCountMap, moneyAmount, totalWinningAmount);
    }

    private static int getTotalWinningAmount(List<LottoNumbers> userLottos, Set<Integer> winningNumbers, Map<Integer, Integer> matchCountMap) {
        int totalWinningAmount = 0;
        Win win = new Win();
        for (LottoNumbers userLotto : userLottos) {
            int matchCount = win.countMatchingNumbers(winningNumbers, userLotto);
            totalWinningAmount = processMatchingLotto(matchCountMap, matchCount, totalWinningAmount, win);
        }
        return totalWinningAmount;
    }

    private static int processMatchingLotto(Map<Integer, Integer> matchCountMap, int matchCount, int totalWinningAmount, Win win) {
        if (matchCount >= 3) {
            matchCountMap.put(matchCount, matchCountMap.get(matchCount) + 1);
            totalWinningAmount += win.getPrizeMoney(matchCount);
        }
        return totalWinningAmount;
    }

    private static void printResults(Map<Integer, Integer> matchCountMap, int moneyAmount, int totalWinningAmount) {
        Win win = new Win();
        ResultView.printResult();
        for (int matchCount : matchCountMap.keySet()) {
            int prizeMoney = win.getPrizeMoney(matchCount);
            int count = matchCountMap.get(matchCount);
            ResultView.printMatchCount(matchCount, prizeMoney, count);
        }

        double winningRate = win.calculateWinningRate(moneyAmount, totalWinningAmount);
        ResultView.printWinningRate(winningRate);
    }

    private static Map<Integer, Integer> initializeMatchCountMap() {
        Map<Integer, Integer> matchCountMap = new HashMap<>();
        for (WinningPrize prize : WinningPrize.values()) {
            matchCountMap.put(prize.getMatchCount(), 0);
        }
        return matchCountMap;
    }

    private static List<LottoNumbers> generateLottoNumbers(int amount) {
        Lotto lotto = new Lotto();

        List<LottoNumbers> userLottos = new ArrayList<>();

        for (int i = 1; i <= amount; i++) {
            LottoNumbers selectedNumbers = lotto.generateLotto();
            ResultView.printLottoNumbers(selectedNumbers);
            userLottos.add(selectedNumbers);
        }
        return userLottos;
    }

    private static int calculateLottoAmount(LottoMoney money) {
        int amount = money.calculateLottoAmount();
        ResultView.printLottoAmount(amount);
        return amount;
    }
}
