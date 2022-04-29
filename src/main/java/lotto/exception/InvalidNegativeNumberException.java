package lotto.exception;

public class InvalidNegativeNumberException extends RuntimeException {
    private static final String MESSAGE = "%s은 양수여야 합니다(현재입력: %s).";

    public InvalidNegativeNumberException(String target, int value) {
        super(String.format(MESSAGE, target, value));
    }
}
