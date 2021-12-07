package lotto;

import java.util.*;

public class LottoNumbers {
    private final Set<LottoNumber> values;

    private LottoNumbers(Set<LottoNumber> input) {
        this.values = input;
    }

    public static LottoNumbers from(Set<Integer> input) {
        if (input == null || input.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 중복 없이 6자리여야 합니다.");
        }

        Set<LottoNumber> newLottoNumbers = new HashSet<>();

        for (Integer number : input) {
            LottoNumber lottoNumber = new LottoNumber(number);
            newLottoNumbers.add(lottoNumber);
        }

        return new LottoNumbers(newLottoNumbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(values, that.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }

    @Override
    public String toString() {
        return "LottoNumbers{" +
                "values=" + values +
                '}';
    }
}
