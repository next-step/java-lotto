package exception;

public class InValidLottoPriceException extends IllegalArgumentException {
    public static final String MESSAGE = "최소 금액은 0원 이상입니다.";

    public InValidLottoPriceException() {
        super(MESSAGE);
    }
}
