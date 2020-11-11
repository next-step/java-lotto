package step1.exception;

public class MinNumZeroException extends RuntimeException {
    private static final String MIN_NUM_ZERO = "0이하의 숫자는 넣을수 없습니다.";

    public MinNumZeroException() {
        super(MIN_NUM_ZERO);
    }
}
