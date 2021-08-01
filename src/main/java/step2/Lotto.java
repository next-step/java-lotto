package step2;

import java.util.List;
import java.util.Objects;

public class Lotto {
    public static final int LOTTO_NUMBER_SIZE = 6;

    private final LottoNumbers lottoNumbers;

    public Lotto(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("주어진 숫자의 갯수가 6보다 작거나 큽니다.");
        }

        this.lottoNumbers = new LottoNumbers(numbers);
    }

    public int countMatch(Lotto lotto) {
        return this.lottoNumbers.countMatch(lotto.lottoNumbers);
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

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
