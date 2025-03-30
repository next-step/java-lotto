package step4.lotto.exception;


public class CountInvalidValueException extends CountException {

    static final String MESSAGE = "카운트는 0 이상의 양의 정수여야 합니다.";

    public CountInvalidValueException() {
        super(MESSAGE);
    }

}
