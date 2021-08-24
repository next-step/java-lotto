package lotto;

import java.util.*;
import java.util.stream.Collectors;

public class LottoNumbers {
    private static final int MIN_LENGTH = 6;

    private Set<Integer> lottoNumbers;

    public LottoNumbers(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != MIN_LENGTH) {
            throw new IllegalArgumentException("Length must be 6.");
        }

        lottoNumbers = lottoNumbers.stream().filter(integer -> integer > 0 && integer < 46).collect(Collectors.toList());

        if (lottoNumbers.size() != MIN_LENGTH) {
            throw new IllegalArgumentException("Numbers can only be entered from 1 to 45.");
        }

        this.lottoNumbers = new TreeSet<>(lottoNumbers);
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
