package lotto.domain;

public class Money {

    private static final String LESS_THOUSAND_ERROR_MESSAGE = "구매 금액은 1000원 이하일 수 없습니다.";
    private static final String NEGATIVE_NUMBER_ERROR_MESSAGE = "구매 금액은 음수일 수 없습니다.";
    private static final String NON_NUMBER_ERROR_MESSAGE = "구매 금액은 정수만 가능합니다.";
    private static final int LOTTO_PRICE = 1000;
    private static final int NUMBER_ZERO = 0;

    private final int value;

    public Money(final String value) {
        int tempValue = validateTypeInput(value);
        validateTypeLessThousand(tempValue);
        validateTypeNegativeNumber(tempValue);
        this.value = tempValue;
    }

    public Money(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public double getPrizeRatio(final Money totalPrize, final Money money) {
        return totalPrize.getValue() / (double) money.getValue();
    }

    private void validateTypeLessThousand(final int value) {
        if (value < LOTTO_PRICE) {
            throw new IllegalArgumentException(LESS_THOUSAND_ERROR_MESSAGE);
        }
    }

    private void validateTypeNegativeNumber(final int value) {
        if (value < NUMBER_ZERO) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_ERROR_MESSAGE);
        }
    }

    private int validateTypeInput(final String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(NON_NUMBER_ERROR_MESSAGE);
        }
    }
}

