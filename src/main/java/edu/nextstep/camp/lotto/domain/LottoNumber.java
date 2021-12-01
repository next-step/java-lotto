package edu.nextstep.camp.lotto.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int MINIMUM = 1;
    private static final int MAXIMUM = 45;

    private static final Map<Integer, LottoNumber> lottoNumberMap = new HashMap<>();

    static {
        for (int i = MINIMUM; i <= MAXIMUM; i++) {
            lottoNumberMap.put(i, new LottoNumber(i));
        }
    }

    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static Collection<LottoNumber> totalNumbers() {
        return lottoNumberMap.values();
    }

    public static LottoNumber of(int number) {
        if (!lottoNumberMap.containsKey(number)) {
            throw new IllegalArgumentException("invalid input: the number must be between 1 and 45. number: " + number);
        }

        return lottoNumberMap.get(number);
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

    public String toString() {
        return Integer.toString(number);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(number, o.number);
    }
}
