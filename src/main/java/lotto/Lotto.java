package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lotto {
    private final List<LottoNumber> lottoNumbers;

    private Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto from(List<Integer> numbers) {
        if (numbers.size() < 6) {
            throw new IllegalArgumentException("로또 숫자는 6자리여야 합니다.");
        }

        List<LottoNumber> newLottoNumbers = new ArrayList<>();

        for (Integer number : numbers) {
            LottoNumber lottoNumber = new LottoNumber(number);
            newLottoNumbers.add(lottoNumber);
        }

        return new Lotto(newLottoNumbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
