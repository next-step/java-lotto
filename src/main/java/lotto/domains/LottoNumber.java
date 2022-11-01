package lotto.domains;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;
import lotto.exceptions.InvalidLottoNumberException;
import lotto.exceptions.LottoNumberFormatException;

public class LottoNumber {
    protected static final int START_NUMBER = 1;
    protected static final int END_NUMBER = 45;

    private final int number;
    private static Map<Integer, LottoNumber> cache = new HashMap<>();

    static {
        IntStream.rangeClosed(START_NUMBER, END_NUMBER)
                .forEach(i -> cache.put(i, new LottoNumber(i)));
    }

    protected static LottoNumber of(String string) {
        try {
            return get(Integer.parseInt(string));
        } catch (NumberFormatException e) {
            throw new LottoNumberFormatException(string);
        }
    }

    protected static LottoNumber of(int number) {
        return get(number);
    }

    private static LottoNumber get(int number) {
        if (!cache.containsKey(number)) {
            throw new InvalidLottoNumberException(number);
        }
        return cache.get(number);
    }

    private LottoNumber(int number) {
        validateNumber(number);
        this.number = number;
    }

    private void validateNumber(int number) {
        if (number < START_NUMBER || END_NUMBER < number) {
            throw new InvalidLottoNumberException(number);
        }
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
        return number == that.number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
