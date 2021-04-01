package lotto.exception;

public class IllegalStringException extends IllegalArgumentException {
    private final static String CHECK_CHARACTER = "%s는 정수로 변환할 수 없는 문자입니다.";

    public IllegalStringException(String input) {
        super(String.format(CHECK_CHARACTER, input));
    }
}
