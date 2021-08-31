package lotto;

import java.util.*;

public class LottoNumbers {
    private static final int MIN_LENGTH = 6;

    private final Set<LottoNumber> lottoNumbers;

    public LottoNumbers(List<Integer> lottoNumbers) {
        lottoNumbers = validation(lottoNumbers);
        List<LottoNumber> lottoNumberList = new ArrayList<>();

        for (Integer number : lottoNumbers) {
            lottoNumberList.add(new LottoNumber(number));
        }

        this.lottoNumbers = new TreeSet<>(lottoNumberList);
    }

    private List<Integer> validation(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != MIN_LENGTH) {
            throw new IllegalArgumentException("Length must be 6.");
        }

        if (new TreeSet<>(lottoNumbers).size() < MIN_LENGTH) {
            throw new IllegalArgumentException("You cannot enter the same value.");
        }
        return lottoNumbers;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    public int match(Lotto lotto) {
        return (int) this.lottoNumbers.stream()
                .filter(lotto::existNumber)
                .count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        return "LottoNumbers{" +
                "lottoNumbers=" + lottoNumbers +
                '}';
    }
}
