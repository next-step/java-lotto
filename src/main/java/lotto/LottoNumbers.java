package lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoNumbers {
    private static final int MIN_LENGTH = 6;

    private List<Integer> lottoNumbers;

    public LottoNumbers(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != MIN_LENGTH) {
            throw new IllegalArgumentException("you must input size 6");
        }
        this.lottoNumbers = lottoNumbers;
    }

    public void sort() {
        Collections.sort(this.lottoNumbers);
    }

    public boolean contains(int number) {
        return this.lottoNumbers.contains(number);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Arrays.equals(this.lottoNumbers.toArray(), that.lottoNumbers.toArray()) && this.lottoNumbers.containsAll(that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
