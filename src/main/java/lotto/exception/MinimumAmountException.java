package lotto.exception;

public class MinimumAmountException extends IllegalArgumentException {

    private static final String MESSAGE = "금액은 %d원 이상이어야 합니다.";

    public MinimumAmountException(Long minimumAmount) {
        super(String.format(MESSAGE, minimumAmount));
    }

}
