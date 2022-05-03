package lotto.exception;

public class InvalidBonusNumberException extends RuntimeException {
    private static final String MESSAGE = "당첨 번호와 보너스 볼은 일치할 수 없습니다(입력된 보너스 번호: %s).";

    public InvalidBonusNumberException(int number) {
        super(String.format(MESSAGE, number));
    }
}
