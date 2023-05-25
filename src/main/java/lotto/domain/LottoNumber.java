package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {


    private static final List<LottoNumber> LOTTO_NUMBERS;

    static {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            LottoNumber lottoNumber = new LottoNumber(i);
            lottoNumbers.add(lottoNumber);
        }
        LOTTO_NUMBERS = Collections.unmodifiableList(lottoNumbers);
    }

    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber valueOf(int number) {
        if (number < 1 || 45 < number) {
            throw new IllegalArgumentException("1부터 45의 숫자만 생성 가능합니다.");
        }
        return LOTTO_NUMBERS.get(number - 1);
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
