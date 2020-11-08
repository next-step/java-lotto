package lotto.domain.exception;

public class InvalidDuplicatedLottoNumbersException extends RuntimeException {
    private static final String MESSAGE = "로또 숫자는 6개 모두 중복이 없여야 합니다.";

    public InvalidDuplicatedLottoNumbersException() {
        super(MESSAGE);
    }
}
