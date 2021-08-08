package lotto.exception;

public class LottoNumberRangeException extends IllegalArgumentException {
    private static final String MESSAGE = "로또 숫자는 1 ~ 45 사이의 숫자만 가능 합니다.";

    public LottoNumberRangeException() {
        super(MESSAGE);
    }
}
