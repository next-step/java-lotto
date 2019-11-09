package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    static final int MIN = 1;
    static final int MAX = 45;
    private static final Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();
    private final int no;

    static {
        for (int i = MIN; i <= MAX; i++) {
            lottoNumbers.put(i, new LottoNumber(i));
        }
    }

    private LottoNumber(final int no) {
        this.no = no;
    }

    public static LottoNumber of(final int no) {
        if (no < MIN || MAX < no) {
            throw new IllegalArgumentException(String.format("로또번호는 %s 이상, %s 이하여야 합니다.", MIN, MAX));
        }

        return lottoNumbers.get(no);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber lottoNumber = (LottoNumber) o;
        return no == lottoNumber.no;
    }

    @Override
    public int hashCode() {
        return Objects.hash(no);
    }

    @Override
    public String toString() {
        return String.valueOf(this.no);
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        return this.no - lottoNumber.no;
    }
}
