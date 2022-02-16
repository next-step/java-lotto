package lotto.domain.ticket;

public class Money {

    private static final String NEGATIVE_ERROR_MESSAGE = "구입금액은 음의 정수가 될 수 없습니다.";

    private final int value;

    public Money(final int value) {
        validateMoney(value);
        this.value = value;
    }

    private void validateMoney(final int value) {
        if (value <= 0) {
            throw new IllegalArgumentException(NEGATIVE_ERROR_MESSAGE);
        }
    }

    public int getValue() {
        return this.value;
    }
}
