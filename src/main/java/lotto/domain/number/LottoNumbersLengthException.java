package lotto.domain.number;

public class LottoNumbersLengthException extends RuntimeException {
    public static final String MESSAGE = "로또 번호는 6자리여야 합니다.";

    public LottoNumbersLengthException() {
        super(MESSAGE);
    }
}
