package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumber implements Comparable<LottoNumber> {

    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 45;

    private final int value;

    private LottoNumber(int value) {
        validate(value);
        this.value = value;
    }

    private static void validate(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalArgumentException("해당 로또번호는 없습니다.");
        }
    }

    public static LottoNumber valueOf(int value) {
        validate(value);
        return LottoNumberCache.lottoNumbers.get(value - 1);
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(value, o.value);
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
        return value;
    }

    private static class LottoNumberCache {
        private static final List<LottoNumber> lottoNumbers = new ArrayList<>(MAX_VALUE);
        static {
            for (int i = MIN_VALUE; i <= MAX_VALUE; i++) {
                lottoNumbers.add(new LottoNumber(i));
            }
        }
    }

}
