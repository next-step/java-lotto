package lotto;

import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.*;

public class LottoAuto {

    private static final int LOTTO_PRICE = 1000;
    private static final List<List<Integer>> lottoList = new ArrayList<>();
    private static final Map<Integer, Integer> winningStatisticsMap = new HashMap<>();
    private static List<Integer> lastWeekWinningNumber;
    private static int totalLottoCount;
    private static int amount;

    public static void inputBuyAmount() {
        amount = InputView.inputBuyAmount();
    }

    public static void buyAuto(int amount) {
        totalLottoCount = amount / LOTTO_PRICE;
        ResultView.printBuyCompleted(String.valueOf(totalLottoCount));
    }

    public static void addLotto(int totalLottoCount) {
        for (int count = 0; count < totalLottoCount; count++) {
            lottoList.add(createLottoNumbers());
        }
        ResultView.printLottoList(lottoList);
    }

    public static void inputLastWeekWinningNumber() {
        lastWeekWinningNumber = InputView.inputLastWeekWinningNumber();
    }

    public static void winningStatistics() {
        setUpWinningStatisticsMap();
        for (List<Integer> lotto : lottoList) {
            addWinningStatistics(getMatchedCount(lotto, lastWeekWinningNumber));
        }
        ResultView.printResult(winningStatisticsMap, amount);
    }

    static List<Integer> createLottoNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return numbers.subList(0, 6);
    }

    private static int getMatchedCount(List<Integer> lotto, List<Integer> lastWeekWinningNumber) {
        int mathcedCount = 0;
        for (Integer number : lotto) {
            mathcedCount += lastWeekWinningNumber.contains(number) ? 1 : 0;
        }
        return mathcedCount;
    }

    private static void addWinningStatistics(int matchedCount) {
        if (matchedCount >= 3) {
            winningStatisticsMap.put(matchedCount, winningStatisticsMap.get(matchedCount) + 1);
        }
    }

    private static void setUpWinningStatisticsMap() {
        for (int number = 3; number <= 6; number++) {
            winningStatisticsMap.put(number, 0);
        }
    }

}
