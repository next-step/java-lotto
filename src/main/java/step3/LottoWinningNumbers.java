package step3;

import java.util.*;

public class LottoWinningNumbers {

    static int LOTTO_BONUS_NUMBER;
    private List<Integer> winningNumbers;

    public LottoWinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = new ArrayList<>(winningNumbers);
    }

    public static List<Integer> valueOf(LottoWinningNumbers lottoWinningNumbers) {
        return lottoWinningNumbers.winningNumbers;
    }

    public static LottoWinningNumbers creatLottoWinningNumbers(String[] inputWinningNumbers) {
        checkWinningNumberLength(inputWinningNumbers);
        checkOverlapWinningNumber(inputWinningNumbers);

        return new LottoWinningNumbers(checkWinningNumberRange(inputWinningNumbers));
    }

    private static void checkWinningNumberLength(String[] inputWinningNumbers) {
        if (inputWinningNumbers.length != LottoGenerator.WINNING_NUMBERS_LENGTH)
            throw new IllegalArgumentException("당첨번호는" + LottoGenerator.WINNING_NUMBERS_LENGTH + "개를 입력하셔야 합니다.");
    }

    private static void checkOverlapWinningNumber(String[] inputWinningNumbers) {
        Set<String> uniqueWinningNumber = new HashSet<>(Arrays.asList(inputWinningNumbers));
        if (uniqueWinningNumber.size() != inputWinningNumbers.length)
            throw new IllegalArgumentException("당첨번호에 중복된 값이 있습니다.");
    }

    private static ArrayList<Integer> checkWinningNumberRange(String[] inputWinningNumbers) {
        ArrayList<Integer> inputWinningNumberList = new ArrayList<>();
        for (int i = 0; i < LottoGenerator.WINNING_NUMBERS_LENGTH; i++) {
            checkEachWinningNumber(Integer.parseInt((inputWinningNumbers[i])));
            inputWinningNumberList.add(Integer.parseInt((inputWinningNumbers[i])));
        }
        Collections.sort(inputWinningNumberList);
        return inputWinningNumberList;
    }

    private static void checkEachWinningNumber(int bonusNumber) {
        if (bonusNumber > 45 || bonusNumber < 1)
            throw new IllegalArgumentException("당첨번호와 보너스 볼은 " + 1 + " ~ " + 45 + "사이로 입력하셔야 합니다.");
    }

    public static void checkBonusNumber(LottoWinningNumbers inputWinningNumberList) {
        checkEachWinningNumber(LOTTO_BONUS_NUMBER);
        for (int winningNumber : inputWinningNumberList.winningNumbers) {
            checkOverlapBonusNumber(winningNumber);
        }
    }

    public static void checkOverlapBonusNumber(int winningNumber) {
        if (winningNumber == LOTTO_BONUS_NUMBER)
            throw new IllegalArgumentException("입력 된 당첨번호 중에 보너스 번호와 중복되는 값이 있습니다.");
    }
}
