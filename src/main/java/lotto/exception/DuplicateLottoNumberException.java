package lotto.exception;

public class DuplicateLottoNumberException extends RuntimeException {

    private static final String DUPLICATE_LOTTO_NUMBER_EXCEPTION_MESSAGE = "중복된 로또 번호가 존재합니다.";

    public DuplicateLottoNumberException() {
        super(DUPLICATE_LOTTO_NUMBER_EXCEPTION_MESSAGE);
    }
}
