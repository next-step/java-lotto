package lotto.view.exception;

public class InvalidInputTotalAmountException extends NumberFormatException {

    private static final String message = "구입금액은 0원 이상의 정수형이어야 합니다.";

    public InvalidInputTotalAmountException() {
        super(message);
    }
}
