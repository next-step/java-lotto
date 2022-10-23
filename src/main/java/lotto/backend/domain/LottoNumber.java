package lotto.backend.domain;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final Map<Integer, LottoNumber> cachedLottoNumber = new HashMap<>();

    static {
        IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
                .forEach(i -> cachedLottoNumber.put(i, new LottoNumber(i)));
    }

    private final int value;

    private LottoNumber(final int number) {
        checkNumberRange(number);
        this.value = number;
    }

    public static LottoNumber of(int number) {
        return new LottoNumber(number);
    }

    public static List<LottoNumber> createNumbers(int size) {
        List<Integer> keys = new ArrayList(cachedLottoNumber.keySet());
        Collections.shuffle(keys);
        return keys.stream()
                .limit(size)
                .map(LottoNumber::new)
                .collect(toList());
    }

    private static void checkNumberRange(int number) {
        if (MIN_LOTTO_NUMBER > number || MAX_LOTTO_NUMBER < number) {
            throw new IllegalArgumentException("입력 값은 1 이상 45 이하입니다.");
        }
    }

    public String print() {
        return String.valueOf(this.value);
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
}
