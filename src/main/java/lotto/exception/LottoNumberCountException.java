package lotto.exception;

public class LottoNumberCountException extends RuntimeException {
    public static final String COUNT_SIZE_EXCEPTION = "구입할 로또 개수를 잘못 입력 했습니다";

    public LottoNumberCountException() {
        super(COUNT_SIZE_EXCEPTION);
    }
}
