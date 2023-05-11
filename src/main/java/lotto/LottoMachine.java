package lotto;

import lotto.common.code.MatchedNumber;
import lotto.common.code.LottoNumber;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.*;

public class LottoMachine {

    private static final String BONUS_BALL_ERROR_TEXT = "로또 번호에 포함된 보너스 볼은 입력할 수 없습니다.";
    private static final String OVER_RANGE_LOTTO_NUMBER_TEXT = "번호는 1 - 45까지 입력할 수 있습니다.";
    private static final int LOTTO_PRICE = 1000;
    private static final int MINIMUM_MATCHED_NUMBER = 3;
    private static final List<Lotto> lottoList = new ArrayList<>();
    private static final Map<MatchedNumber, Integer> winningStatisticsMap = new LinkedHashMap<>();
    private static List<Integer> lastWeekWinningNumber;
    private static int totalLottoCount;
    private static int manuallyLottoCount;
    private static int amount;
    private static int bonusBallNumber;

    public static void main(String[] args) {
        inputBuyAmount();
        inputBuyManually();
        inputManuallyLottoNumbers();
        buyAuto();
        addLotto(totalLottoCount);
        inputLastWeekWinningNumber();
        inputBonusBallNumber();
        winningStatistics();
    }

    public static void inputBuyAmount() {
        amount = InputView.inputBuyAmount();
        totalLottoCount = amount / LOTTO_PRICE;
    }

    public static void inputBuyManually() {
        manuallyLottoCount = InputView.inputBuyManuallyCount();
        int totalManuallyAmount = LOTTO_PRICE * manuallyLottoCount;
        amount = amount - totalManuallyAmount;
    }

    public static void inputManuallyLottoNumbers() {
        InputView.printInputManuallyLottoNumbers();
        for (int i = 0; i < manuallyLottoCount; i++) {
            lottoList.add(createLotto(InputView.inputManuallyLottoNumbers()));
        }
    }

    public static void buyAuto() {
        ResultView.printBuyCompleted(totalLottoCount, manuallyLottoCount);
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
        if (hasLottoNumbers(lastWeekWinningNumber, bonusBallNumber)) throw new IllegalArgumentException(BONUS_BALL_ERROR_TEXT);
        if (isNotWithinLotteryNumberRange(bonusBallNumber)) throw new IllegalArgumentException(OVER_RANGE_LOTTO_NUMBER_TEXT);
    }

    public static void winningStatistics() {
        setUpWinningStatisticsMap();
        for (Lotto lotto : lottoList) {
            addWinningStatistics(getMatchedCount(lotto.getNumbers(), lastWeekWinningNumber), isMatchedBonusNumber(lotto.getNumbers(), lastWeekWinningNumber, bonusBallNumber));
        }
        ResultView.printResult(winningStatisticsMap, amount);
    }

    static boolean isMatchedBonusNumber(List<Integer> lottoNumbers, List<Integer> lastWeekWinningNumber, int bonusBallNumber) {
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

    static Lotto createLotto(List<Integer> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    static int getMatchedCount(List<Integer> lottoNumbers, List<Integer> lastWeekWinningNumber) {
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

    static void setUpWinningStatisticsMap() {
        EnumSet.allOf(MatchedNumber.class).forEach(matchedNumber -> winningStatisticsMap.put(matchedNumber, 0));
    }

    static boolean hasLottoNumbers(List<Integer> lastWeekWinningNumber, int bonusNumber) {
        return lastWeekWinningNumber.contains(bonusNumber);
    }

    static boolean isNotWithinLotteryNumberRange(int bonusNumber) {
        return !(bonusNumber >= LottoNumber.MINIMUM_LOTTO_NUMBER.getNumber()
                && bonusNumber <= LottoNumber.MAXIMUM_LOTTO_NUMBER.getNumber());
    }

}
