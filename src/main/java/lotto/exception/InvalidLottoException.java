package lotto.exception;

import static lotto.domain.lotto.Lotto.LOTTO_NUMBER_SIZE;

public class InvalidLottoException extends IllegalArgumentException {
    private static final String WRONG_LOTTO_NUMBERS_SIZE_MESSAGE = "로또 번호는 중복이 없어야 하며 %d개여야 합니다.";

    public InvalidLottoException() {
        super(String.format(WRONG_LOTTO_NUMBERS_SIZE_MESSAGE, LOTTO_NUMBER_SIZE));
    }
}
