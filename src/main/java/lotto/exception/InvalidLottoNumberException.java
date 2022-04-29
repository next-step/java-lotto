package lotto.exception;

public class InvalidLottoNumberException extends RuntimeException {
    private static final String MESSAGE = "유효한 로또 숫자는 1부터 45까지입니다(입력된 숫자: %s).";

    public InvalidLottoNumberException(int number) {
        super(String.format(MESSAGE, number));
    }
}
