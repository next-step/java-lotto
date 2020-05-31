package lotto.domain.number;

public class IncorrectLottoNumberException extends RuntimeException {
    public static final String MESSAGE = "로또 번호는 1~45 사이의 숫자만 가능합니다.";

    public IncorrectLottoNumberException() {
        super(MESSAGE);
    }
}
