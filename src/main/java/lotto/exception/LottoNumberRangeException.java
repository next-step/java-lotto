package lotto.exception;

public class LottoNumberRangeException extends RuntimeException {
    private static final String NUMBER_RANGE_EXCEPTION_MSG = "숫자는 %d부터 %d까지만 입력 가능합니다.";

    public LottoNumberRangeException(int minNumber, int maxNumber) {
        System.out.printf(NUMBER_RANGE_EXCEPTION_MSG, minNumber, maxNumber);
    }
}
