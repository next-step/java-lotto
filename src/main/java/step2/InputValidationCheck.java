package step2;

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

    public static void checkWinningNumbers(String[] inputWinningNumbers) {
        int winningNumberLength = inputWinningNumbers.length;

        if (winningNumberLength != Lotto.WINNING_NUMBERS_LENGTH) {
            throw new IllegalArgumentException("당첨번호는" + Lotto.WINNING_NUMBERS_LENGTH + "개를 입력하셔야 합니다.");
        }
    }

    public static void checkWinningNumberRange(String[] winningNumbers) {
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
