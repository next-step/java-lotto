
package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int NUMBER_UPPER_BOUND = 45;
    private static final int NUMBER_LOWER_BOUND = 1;
    private final int number;

    public LottoNumber(int number) {
        validateNumberBound(number);
        this.number = number;
    }

    private void validateNumberBound(int number) {
        if (number < NUMBER_LOWER_BOUND || number > NUMBER_UPPER_BOUND)
            throw new IllegalArgumentException(String.format("number should be between %d and %d.", NUMBER_LOWER_BOUND, NUMBER_UPPER_BOUND));
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }

    @Override
    public int compareTo(LottoNumber other) {
        return this.number - other.number;
    }
}
