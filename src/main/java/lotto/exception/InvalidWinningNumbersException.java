package lotto.exception;

import static lotto.domain.lotto.Lotto.LOTTO_NUMBER_SIZE;

public class InvalidWinningNumbersException extends IllegalArgumentException {
    private static final String WRONG_WINNING_NUMBERS_SIZE_MESSAGE = "당첨 번호는 중복이 없어야 하며 %d개여야 합니다.";

    public InvalidWinningNumbersException() {
        super(String.format(WRONG_WINNING_NUMBERS_SIZE_MESSAGE, LOTTO_NUMBER_SIZE));
    }
}
