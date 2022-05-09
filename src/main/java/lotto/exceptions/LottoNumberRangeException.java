package lotto.exceptions;

public class LottoNumberRangeException extends IllegalArgumentException {
    private static final String MESSAGE = "로또번호는 1부터 45사이 숫자만 생성 가능합니다.";

    public LottoNumberRangeException() {
        super(MESSAGE);
    }

    public LottoNumberRangeException(String message) {
        super(message);
    }
}
