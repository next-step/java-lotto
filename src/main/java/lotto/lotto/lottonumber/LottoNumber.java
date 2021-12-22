package lotto.lotto.lottonumber;

import java.util.Objects;

public class LottoNumber {
    private static final String LOTTO_NUMBER_RANGE_MESSAGE = "로또 번호는 1 이상 45 이하여야 합니다.";
    private static final int MIN = 1;
    private static final int MAX = 45;
    private final int value;

    private LottoNumber(int input) {
        if (input < MIN || input > MAX) {
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_MESSAGE);
        }

        this.value = input;
    }

    public static LottoNumber from(String input) {
        return new LottoNumber(Integer.parseInt(input));
    }

    public static LottoNumber from(int input) {
        return new LottoNumber(input);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "LottoNumber{" +
                "value=" + value +
                '}';
    }
}
