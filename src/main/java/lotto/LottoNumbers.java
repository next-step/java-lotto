package lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoNumbers {
    private static final int MIN_LENGTH = 6;
    private static final int MIN_VALUE = 0;
    private static final int MAX_LENGTH = 45;

    private Set<Integer> lottoNumbers;

    public LottoNumbers(List<Integer> lottoNumbers) {
        lottoNumbers = validation(lottoNumbers);

        this.lottoNumbers = new TreeSet<>(lottoNumbers);
    }

    private List<Integer> validation(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != MIN_LENGTH) {
            throw new IllegalArgumentException("Length must be 6.");
        }

        if (new TreeSet<>(lottoNumbers).size() < MIN_LENGTH) {
            throw new IllegalArgumentException("You cannot enter the same value.");
        }

        lottoNumbers = lottoNumbers.stream().filter(integer -> integer > MIN_VALUE && integer <= MAX_LENGTH).collect(Collectors.toList());

        if (lottoNumbers.size() != MIN_LENGTH) {
            throw new IllegalArgumentException("Numbers can only be entered from 1 to 45.");
        }
        return lottoNumbers;
    }

    public boolean contains(int number) {
        return this.lottoNumbers.contains(number);
    }

    public int match(LottoNumbers lottoNumbers) {
        Stream<Integer> integerStream = this.lottoNumbers.stream().filter(integer -> {
            return lottoNumbers.contains(integer);
        });
        return Arrays.asList(integerStream.toArray()).size();
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
