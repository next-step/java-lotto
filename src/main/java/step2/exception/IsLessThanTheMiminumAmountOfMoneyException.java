package step2.exception;

public class IsLessThanTheMiminumAmountOfMoneyException extends IllegalArgumentException {
    public IsLessThanTheMiminumAmountOfMoneyException(String errorMessage) {
        super(errorMessage);
    }
}
