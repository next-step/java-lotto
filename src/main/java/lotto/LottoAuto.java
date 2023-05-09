package lotto;

import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.*;

public class LottoAuto {

    private static final int LOTTO_PRICE = 1000;
    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;
    private static final int MINIMUM_MATCHED_NUMBER = 3;
    private static final int MAXIMUM_MATCHED_NUMBER = 6;
    private static final List<List<Integer>> lottoList = new ArrayList<>();
    private static final Map<Integer, Integer> winningStatisticsMap = new HashMap<>();
    private static List<Integer> lastWeekWinningNumber;
    private static int totalLottoCount;
    private static int amount;

    public static void main(String[] args) {
        inputBuyAmount();
        buyAuto(amount);
        addLotto(totalLottoCount);
        inputLastWeekWinningNumber();
        winningStatistics();
    }

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
        for (int i = MINIMUM_LOTTO_NUMBER; i <= MAXIMUM_LOTTO_NUMBER; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return numbers.subList(0, 6);
    }

    private static int getMatchedCount(List<Integer> lotto, List<Integer> lastWeekWinningNumber) {
        int matchedCount = 0;
        for (Integer number : lotto) {
            matchedCount += lastWeekWinningNumber.contains(number) ? 1 : 0;
        }
        return matchedCount;
    }

    private static void addWinningStatistics(int matchedCount) {
        if (matchedCount >= MINIMUM_MATCHED_NUMBER) {
            winningStatisticsMap.put(matchedCount, winningStatisticsMap.get(matchedCount) + 1);
        }
    }

    private static void setUpWinningStatisticsMap() {
        for (int number = MINIMUM_MATCHED_NUMBER; number <= MAXIMUM_MATCHED_NUMBER; number++) {
            winningStatisticsMap.put(number, 0);
        }
    }

}
