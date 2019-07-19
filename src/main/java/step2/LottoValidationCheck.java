package step2;

public class LottoValidationCheck {
    public static void checkLottoNumbersRange(String[] winningNumbers) {
        for (int i = 0; i < Lotto.WINNING_NUMBERS_LENGTH; i++) {
            checkEachWinningNumber(Integer.parseInt(winningNumbers[i].trim()));
        }
    }

    private static void checkEachWinningNumber(int winningNumber) {
        if (winningNumber > Lotto.WINNING_NUMBERS_MAX ||
                winningNumber < Lotto.WINNING_NUMBERS_MIN) {
            throw new IllegalArgumentException(
                    "당첨번호는" + Lotto.WINNING_NUMBERS_MIN + " ~ " + Lotto.WINNING_NUMBERS_MAX + "사이로 입력하셔야 합니다.");
        }
    }
}
