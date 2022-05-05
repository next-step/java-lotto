package lotto.domain;

import lotto.exception.InvalidLottoNumberCount;

import java.util.*;

public class LottoMarkingNumbers {

    public static final int LOTTO_NUMBER_COUNT = 6;
    private final Set<LottoNumber> lottoNumbers;

    public LottoMarkingNumbers(List<LottoNumber> lottoNumbers) {
        this(new TreeSet<>(lottoNumbers));
    }

    public LottoMarkingNumbers(TreeSet<LottoNumber> lottoNumberTreeSet) {
        if (lottoNumberTreeSet.size() != LOTTO_NUMBER_COUNT) {
            throw new InvalidLottoNumberCount();
        }
        this.lottoNumbers = lottoNumberTreeSet;
    }

    public int matchCount(WinningNumbers winningNumbers) {
        return (int) lottoNumbers.stream()
                .filter(lottoNumber -> winningNumbers.isWinningNumber(lottoNumber))
                .count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoMarkingNumbers that = (LottoMarkingNumbers) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
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
