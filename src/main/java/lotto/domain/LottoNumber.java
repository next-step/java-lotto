package lotto.domain;

import java.util.*;

public class LottoNumber implements Comparable<LottoNumber> {


    private static final Set<LottoNumber> LOTTO_NUMBERS;

    static {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        for (int i = 1; i <= 45; i++) {
            LottoNumber lottoNumber = new LottoNumber(i);
            lottoNumbers.add(lottoNumber);
        }
        LOTTO_NUMBERS = Collections.unmodifiableSet(lottoNumbers);
    }

    private final int number;

    LottoNumber(int number) {
        if (number < 1 || 45 < number) {
            throw new IllegalArgumentException("1부터 45의 숫자만 생성 가능합니다.");
        }
        this.number = number;
    }

    public static List<LottoNumber> lottoNumbers() {
        return new ArrayList<>(LOTTO_NUMBERS);
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
