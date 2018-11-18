package lotto.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class LottoNumber {
    private static final Map<Integer, LottoNumber> definedNumbers = new HashMap<>();
    static {
        IntStream.range(1, 45)
            .forEach(rangeNumber -> definedNumbers.put(rangeNumber, LottoNumber.from(rangeNumber)));
    }

    private int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber from(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException();
        }

        return definedNumbers.get(number);
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
}
