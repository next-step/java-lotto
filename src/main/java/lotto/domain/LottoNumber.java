
package lotto.domain;

import java.util.Objects;

import static lotto.domain.LottoConstant.TICKET_NUMBER_MAX;
import static lotto.domain.LottoConstant.TICKET_NUMBER_MIN;

public class LottoNumber implements Comparable<LottoNumber> {
    private final int number;

    public LottoNumber(int number) {
        validateNumberBound(number);
        this.number = number;
    }

    private void validateNumberBound(int number) {
        if (number < TICKET_NUMBER_MIN || number > TICKET_NUMBER_MAX)
            throw new IllegalArgumentException(String.format("number should be between %d and %d.", TICKET_NUMBER_MIN, TICKET_NUMBER_MAX));
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
