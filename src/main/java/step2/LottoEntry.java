package step2;

import java.util.List;
import java.util.Objects;

public class LottoEntry {
    public static final int LOTTO_NUMBER_SIZE = 6;

    private final LottoNumbers lottoNumbers;

    public LottoEntry(List<Integer> numbers) {
        validate(numbers);

        this.lottoNumbers = new LottoNumbers(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("주어진 숫자의 갯수가 6보다 작거나 큽니다.");
        }
    }

    public int countMatch(LottoEntry lottoEntry) {
        return this.lottoNumbers.countMatch(lottoEntry.lottoNumbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoEntry lottoEntry = (LottoEntry) o;
        return Objects.equals(lottoNumbers, lottoEntry.lottoNumbers);
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
