package lotto.exception;

public class LottoSizeException extends RuntimeException {
    private static final String MESSAGE = "번호는 반드시 6개를 입력해야 합니다.";

    public LottoSizeException() {
        super(MESSAGE);
    }

}
