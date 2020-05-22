package lotto.domain.shop.exceptions;

public class OnlyTenThousandsException extends RuntimeException {
    public OnlyTenThousandsException(String message) {
        super(message);
    }
}
