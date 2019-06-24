package lotto.exception;

import static lotto.model.Lotto.SIZE;

public class InvalidCountOfLottoException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "%d개의 로또번호를 입력해주세요. (입력값: %d)";

    public InvalidCountOfLottoException(int inputLottoSize) {
        super(String.format(ERROR_MESSAGE, SIZE, inputLottoSize));
    }
}
