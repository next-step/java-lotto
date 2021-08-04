package lotto.model;

public class WinningNumber {
    private static final int MIN_WINNING_NUMBER = 1;
    private static final int MAX_WINNING_NUMBER = 45;

    private int number;

    WinningNumber(int number) {
        validateRange(number);
        this.number = number;
    }

    private void validateRange(int number) {
        if (number < MIN_WINNING_NUMBER || number > MAX_WINNING_NUMBER) {
            throw new IllegalArgumentException(String.format("당첨 번호는 %d이상 %d이하 이어야 합니다."
                    , MIN_WINNING_NUMBER, MAX_WINNING_NUMBER));
        }
    }
}
