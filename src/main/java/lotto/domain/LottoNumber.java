package lotto.domain;

import lotto.dto.NumberData;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int NUM_LEFT_BOUND = 1;
    public static final int NUM_RIGHT_BOUND = 45;
    private static final String NUMBER_BOUND_ERROR_MSG = String.format(
        "로또 번호는 %d 이상, %d 이하의 정수여야 합니다", NUM_LEFT_BOUND, NUM_RIGHT_BOUND
    );

    private Integer number;

    public LottoNumber(String string) {
        int number = Integer.parseInt(string);
        checkBounds(number);
        this.number = number;
    }

    public LottoNumber(int number) {
        checkBounds(number);
        this.number = number;
    }

    private void checkBounds(int number) {
        if (number < NUM_LEFT_BOUND || number > NUM_RIGHT_BOUND) {
            throw new RuntimeException(NUMBER_BOUND_ERROR_MSG);
        }
    }

    public NumberData getNumberData() {
        return new NumberData(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(LottoNumber other) {
        return number.compareTo(other.number);
    }
}
