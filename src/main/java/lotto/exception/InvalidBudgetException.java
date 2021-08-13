package lotto.exception;

public class InvalidBudgetException extends IllegalArgumentException{
    private static final String MESSAGE = "돈을 잘못 입력 하였습니다.";

    public InvalidBudgetException() {
        super(MESSAGE);
    }
}
