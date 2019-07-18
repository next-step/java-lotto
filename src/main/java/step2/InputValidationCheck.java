package step2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InputValidationCheck {

    public static void checkEmpty(String cash) {
        if (cash.isEmpty()) {
            throw new IllegalArgumentException("구매금액이 없으면, 로또구매가 불가합니다.");
        }
    }

    public static void checkCash(String cash) {
        if (Integer.parseInt(cash) < Lotto.LOTTO_PRICE) {
            throw new IllegalArgumentException("로또는 1장에 " + Lotto.LOTTO_PRICE + " 원 입니다.");
        }
    }

    public static void checkWinningNumbers(String[] trimWinningNumbers) {
        if (trimWinningNumbers.length != Lotto.WINNING_NUMBERS_LENGTH) {
            throw new IllegalArgumentException("당첨번호는" + Lotto.WINNING_NUMBERS_LENGTH + "개를 입력하셔야 합니다.");
        }
    }

    public static int[] checkWinningNumberRange(String[] trimWinningNumbers) {
        int[] winningNumbers = new int[Lotto.WINNING_NUMBERS_LENGTH];
        for (int i = 0; i < Lotto.WINNING_NUMBERS_LENGTH; i++) {
            winningNumbers[i] = Integer.parseInt((trimWinningNumbers[i]));
            checkEachWinningNumber(winningNumbers[i]);
        }

        return winningNumbers;
    }

    private static void checkEachWinningNumber(int winningNumber) {
        if (winningNumber > Lotto.WINNING_NUMBERS_MAX || winningNumber < Lotto.WINNING_NUMBERS_MIN) {
            throw new IllegalArgumentException("당첨번호는" + Lotto.WINNING_NUMBERS_MIN + " ~ " + Lotto.WINNING_NUMBERS_MAX + "사이로 입력하셔야 합니다.");
        }
    }

    public static void checkOverlapWinningNumber(String[] winningNumbers) {
        Set<String> uniqueWinningNumber = new HashSet<>(Arrays.asList(winningNumbers));
        if(uniqueWinningNumber.size() != winningNumbers.length){
            throw new IllegalArgumentException("당첨번호에 중복된 값이 있습니다.");
        }
    }

}
