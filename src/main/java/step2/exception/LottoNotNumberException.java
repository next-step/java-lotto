package step2.exception;

public class LottoNotNumberException extends RuntimeException {

    private static final String ERROR_MSG = "숫자만 입력해 주세요";

    public LottoNotNumberException() {
        super(ERROR_MSG);
    }
}
