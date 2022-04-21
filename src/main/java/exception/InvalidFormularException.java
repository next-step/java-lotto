package exception;

public class InvalidFormularException extends RuntimeException {
    private static final String MESSAGE = "ERROR] 연산자 좌우로 공백을 입력해주세요(입력받은 공백: %d, 필요한 공백: %d).";

    public InvalidFormularException(int actual, int expected) {
        super(String.format(MESSAGE, actual, expected));
    }
}
