package lotto.domain;

import lotto.exception.InvalidLottoNumberCountException;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class LottoNumbers {

    private static final int TOTAL_LOTTO_NUMBERS_COUNT = 6;

    private final Set<LottoNumber> lottoNumbers;

    private LottoNumbers(Set<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumbers of(Set<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        return new LottoNumbers(lottoNumbers);
    }

    private static void validate(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != TOTAL_LOTTO_NUMBERS_COUNT) {
            throw new InvalidLottoNumberCountException();
        }
    }

    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public int size() {
        return lottoNumbers.size();
    }

    private boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public int getMatchCount(LottoNumbers winningLottoNumbers) {
        return (int) lottoNumbers.stream()
                .filter(number -> winningLottoNumbers.contains(number))
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
