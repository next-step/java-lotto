package step5.exception;

public class IllegalRankNumberException extends RuntimeException {

    public static final String MESSAGE = "유효하지 않은 랭크 숫자 입니다.";

    public IllegalRankNumberException() {
        super(MESSAGE);
    }
}

