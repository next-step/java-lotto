package lotto.domain;

import lotto.exception.InvalidLottoNumberCount;

import java.util.*;

public class LottoNumbers {

    public static final int LOTTO_NUMBER_COUNT = 6;
    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this(new TreeSet<>(lottoNumbers));
    }

    public LottoNumbers(TreeSet<LottoNumber> lottoNumberTreeSet) {
        if (lottoNumberTreeSet.size() != LOTTO_NUMBER_COUNT) {
            throw new InvalidLottoNumberCount();
        }
        this.lottoNumbers = new ArrayList<>(lottoNumberTreeSet);
    }

    public static LottoNumbers winningLottoNumbers(String[] values) {
        List<LottoNumber> winningLottoNumbers = new ArrayList<>();
        for (String value : values) {
            winningLottoNumbers.add(new LottoNumber(value));
        }
        return new LottoNumbers(winningLottoNumbers);
    }

    public int matchCount(LottoNumbers winningNumbers) {
        return (int) lottoNumbers.stream()
                .filter(lottoNumber -> winningNumbers.isContains(lottoNumber))
                .count();
    }

    private boolean isContains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public List<LottoNumber> toList() {
        return lottoNumbers;
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
        return lottoNumbers.toString();
    }
}
