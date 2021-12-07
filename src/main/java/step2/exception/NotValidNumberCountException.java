package step2.exception;

public class NotValidNumberCountException extends IllegalArgumentException {
    private static final String NOT_VALID_MATCHED_NUMBER_COUNT = "지난 당첨 번호는 중복되지 않은 6개의 숫자여야합니다.";

    public NotValidNumberCountException() {
        super(NOT_VALID_MATCHED_NUMBER_COUNT);
    }
}
