package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoNumbers {
    private final List<LottoNumber> values;

    private LottoNumbers(List<LottoNumber> input) {
        this.values = input;
    }

    public static LottoNumbers from(List<Integer> input) {
        if (input.size() < 6) {
            throw new IllegalArgumentException("로또 숫자는 6자리여야 합니다.");
        }

        List<LottoNumber> newLottoNumbers = new ArrayList<>();

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
