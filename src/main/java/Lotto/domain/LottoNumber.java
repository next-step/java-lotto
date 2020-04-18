package Lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int LOTTO_START_NUMBER = 1;
    public static final int LOTTO_LAST_NUMBER = 45;

    private static final Map<Integer, LottoNumber> numberMap = new HashMap<>();
    static  {
        for (int i = LOTTO_START_NUMBER; i <= LOTTO_LAST_NUMBER ; i++) {
            numberMap.put(i, new LottoNumber(i));
        }
    }

    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber from(int number) {
        validateNumber(number);
        return numberMap.get(number);
    }

    private static void validateNumber(final int number) {
        if (LOTTO_START_NUMBER > number || LOTTO_LAST_NUMBER < number) {
            throw new IllegalArgumentException("Not Allowed Number: " + number);
        }
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.number, o.number);
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
        return String.valueOf(this.number);
    }
}
