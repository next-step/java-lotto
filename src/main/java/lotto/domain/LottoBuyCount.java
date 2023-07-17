package lotto.domain;

import java.util.Objects;

public class LottoBuyCount {

    private static final String NUMBER_PATTERN = "\\d+";
    private static final String NEGATIVE_NUMBER_EXCEPTION_MESSAGE = "로또 구매 숫자는 0이상의 수만 입력받을 수 있습니다.";
    private static final String NOT_ENOUGH_MONEY_EXCEPTION_MESSAGE = "원하는 로또 구매 숫자만큼 로또를 구매하기 위한 금액이 부족합니다.";
    private final int value;

    LottoBuyCount(final int value) {
        this.value = value;
    }

    public LottoBuyCount(final String value, final Money money) {
        validate(value, money);
        this.value = Integer.parseInt(value);
    }

    private void validate(final String value, final Money money) {
        validateNumericPattern(value);
        validateEnoughMoney(value, money);
    }

    private void validateNumericPattern(final String value) {
        if (!value.matches(NUMBER_PATTERN)) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    private void validateEnoughMoney(final String value, final Money money) {
        if (Integer.parseInt(value) * Lotto.PRICE > money.getValue()) {
            throw new IllegalArgumentException(NOT_ENOUGH_MONEY_EXCEPTION_MESSAGE);
        }
    }

    public int getValue() {
        return this.value;
    }

    public boolean isZero() {
        return this.value == 0;
    }

    public LottoBuyCount decrease() {
        return new LottoBuyCount(this.value - 1);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final LottoBuyCount that = (LottoBuyCount) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
