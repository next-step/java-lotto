package lotto.exception;

public class NotANumberException extends RuntimeException {
    private final static String MESSAGE = "%d는 로또번호가 아닙니다.(1 ~ 45 )";

    public NotANumberException(int number) {
        super(String.format(MESSAGE, number));
    }
}
