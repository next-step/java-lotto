package lotto.exception;

public class OutOfLottoNumberSizeException extends RuntimeException {
    private static final String EXCEPTION_MESSAGE = "로또 번호는 6개 숫자만 가집니다.";

    public OutOfLottoNumberSizeException() {
        super(EXCEPTION_MESSAGE);
    }
}
