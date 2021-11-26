package step3.exception;

import static java.lang.String.format;

public class LottoNumberSizeMismatchException extends RuntimeException {

    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final String SIZE_MISMATCH_ERROR_MESSAGE = "로또 번호의 개수는 반드시 %d개 여야 합니다. 입력된 개수 = %d개";

    public LottoNumberSizeMismatchException(int inputLottoSize) {
        super(format(SIZE_MISMATCH_ERROR_MESSAGE, LOTTO_NUMBER_SIZE, inputLottoSize));
    }

}
