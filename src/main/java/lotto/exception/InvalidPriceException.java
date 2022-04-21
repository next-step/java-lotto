package lotto.exception;

public class InvalidPriceException extends RuntimeException {
    private static final String MESSGAE = "구입금액은 양수여야 합니다(현재금액: %s).";

    public InvalidPriceException(int price) {
        super(String.format(MESSGAE, price));
    }
}
