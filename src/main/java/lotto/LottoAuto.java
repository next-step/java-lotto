package lotto;

import lotto.common.code.MatchedNumber;
import lotto.common.code.LottoNumber;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.*;

public class LottoAuto {

    private static final int LOTTO_PRICE = 1000;
    private static final int MINIMUM_MATCHED_NUMBER = 3;
    private static final List<Lotto> lottoList = new ArrayList<>();
    private static final Map<MatchedNumber, Integer> winningStatisticsMap = new LinkedHashMap<>();
    private static List<Integer> lastWeekWinningNumber;
    private static int totalLottoCount;
    private static int amount;
    private static int bonusBallNumber;

    public static void main(String[] args) {
        inputBuyAmount();
        buyAuto(amount);
        addLotto(totalLottoCount);
        inputLastWeekWinningNumber();
        inputBonusBallNumber();
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

    public static void inputBonusBallNumber() {
        bonusBallNumber = InputView.inputBonusBallNumber(lastWeekWinningNumber);
    }

    public static void winningStatistics() {
        setUpWinningStatisticsMap();
        for (Lotto lotto : lottoList) {
            addWinningStatistics(getMatchedCount(lotto.getNumbers(), lastWeekWinningNumber), isMatchedBonusNumber(lotto.getNumbers()));
        }
        ResultView.printResult(winningStatisticsMap, amount);
    }

    static boolean isMatchedBonusNumber(List<Integer> lottoNumbers) {
        List<Integer> copyLottoNumbers = new ArrayList<>(lottoNumbers);
        copyLottoNumbers.removeAll(lastWeekWinningNumber);
        return copyLottoNumbers.contains(bonusBallNumber);
    }

    static Lotto createLottoNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = LottoNumber.MINIMUM_LOTTO_NUMBER.getNumber(); i <= LottoNumber.MAXIMUM_LOTTO_NUMBER.getNumber(); i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return new Lotto(numbers.subList(0, 6));
    }

    private static int getMatchedCount(List<Integer> lottoNumbers, List<Integer> lastWeekWinningNumber) {
        int matchedCount = 0;
        for (Integer number : lottoNumbers) {
            matchedCount += lastWeekWinningNumber.contains(number) ? 1 : 0;
        }
        return matchedCount;
    }

    private static void addWinningStatistics(int matchedCount, boolean isMatchedBonusNumber) {
        if (matchedCount >= MINIMUM_MATCHED_NUMBER) {
            MatchedNumber matchedNumber = MatchedNumber.findByNumberWithMatchedBonus(matchedCount, isMatchedBonusNumber);
            winningStatisticsMap.put(matchedNumber, winningStatisticsMap.get(matchedNumber) + 1);
        }
    }

    private static void setUpWinningStatisticsMap() {
        EnumSet.allOf(MatchedNumber.class).forEach(matchedNumber -> winningStatisticsMap.put(matchedNumber, 0));
    }

}
