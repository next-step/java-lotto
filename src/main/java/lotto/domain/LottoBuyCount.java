package lotto.domain;

import java.util.Objects;

public class LottoBuyCount {

    private static final String NUMBER_PATTERN = "\\d+";
    private static final String NEGATIVE_NUMBER_EXCEPTION_MESSAGE = "로또 구매 숫자는 0이상의 수만 입력받을 수 있습니다.";
    private final int value;

    private LottoBuyCount(final int value) {
        this(String.valueOf(value));
    }

    public LottoBuyCount(final String value) {
        validate(value);
        this.value = Integer.parseInt(value);
    }

    private void validate(final String value) {
        if (!value.matches(NUMBER_PATTERN)) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_EXCEPTION_MESSAGE);
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
