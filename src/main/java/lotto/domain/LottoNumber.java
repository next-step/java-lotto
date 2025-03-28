
package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {
    private static final int NUMBER_UPPER_BOUND = 45;
    private static final int NUMBER_LOWER_BOUND = 1;
    private final int number;

    public LottoNumber(int number) {
        validateNumberBound(number);
        this.number = number;
    }

    private void validateNumberBound(int number) {
        if(number < NUMBER_LOWER_BOUND || number > NUMBER_UPPER_BOUND)
            throw new IllegalArgumentException(String.format("number should be between %d and %d.", NUMBER_LOWER_BOUND, NUMBER_UPPER_BOUND));
    }

    public static List<LottoNumber> getAllNumbers() {
        return IntStream.rangeClosed(NUMBER_LOWER_BOUND, NUMBER_UPPER_BOUND)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
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
}
