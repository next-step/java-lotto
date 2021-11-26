package step3.exception;

import static java.lang.String.format;

public class InvalidLottoNumberRangeException extends RuntimeException {

    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final String RANGE_ERROR_MESSAGE = "로또 번호는 %d부터 %d 사이여야 합니다. 입력된 수 = %d";

    public InvalidLottoNumberRangeException(int lottoNumber) {
        super(format(RANGE_ERROR_MESSAGE, MIN, MAX, lottoNumber));
    }

}
