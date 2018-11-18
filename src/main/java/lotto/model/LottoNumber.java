package lotto.model;

import lotto.LottoConstants;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class LottoNumber {
    private static final Map<Integer, LottoNumber> definedNumbers = new HashMap<>();
    static {
        IntStream.range(LottoConstants.MIN_NUMBER, LottoConstants.MAX_NUMBER)
            .forEach(rangeNumber -> definedNumbers.put(rangeNumber, new LottoNumber(rangeNumber)));
    }

    private int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber from(int number) {
        if (number < LottoConstants.MIN_NUMBER || number > LottoConstants.MAX_NUMBER) {
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

    @Override
    public String toString() {
        return "LottoNumber{" +
                "number=" + number +
                '}';
    }
}
