package lotto.backend.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final Map<Integer, LottoNumber> cachedLottoNumber = new HashMap<>();

    static {
        IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
                .forEach(i -> cachedLottoNumber.put(i, new LottoNumber(i)));
    }

    private final int value;

    public LottoNumber(final int number) {
        checkNumberRange(number);
        this.value = number;
    }

    public static Set<LottoNumber> createNumbers(int size) {
        List<Integer> keys = new ArrayList<>(cachedLottoNumber.keySet());
        Collections.shuffle(keys);
        return keys.stream()
                .limit(size)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
    }

    private static void checkNumberRange(int number) {
        if (MIN_LOTTO_NUMBER > number || MAX_LOTTO_NUMBER < number) {
            throw new IllegalArgumentException("입력 값은 1 이상 45 이하입니다.");
        }
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.value - o.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
