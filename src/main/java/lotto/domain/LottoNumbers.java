package lotto.domain;

import lotto.exception.InvalidLottoNumberCount;
import lotto.util.SplitUtil;

import java.util.*;
import java.util.stream.Collectors;

public class LottoNumbers {

    public static final int LOTTO_NUMBER_COUNT = 6;

    private final Set<LottoNumber> values;

    public LottoNumbers(String values) {
        this(SplitUtil.split(values));
    }

    public LottoNumbers(String[] values) {
        this(convertToSet(values));
    }

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this(new HashSet<>(lottoNumbers));
    }

    public LottoNumbers(Set<LottoNumber> lottoNumberTreeSet) {
        if (lottoNumberTreeSet.size() != LOTTO_NUMBER_COUNT) {
            throw new InvalidLottoNumberCount();
        }
        this.values = lottoNumberTreeSet;
    }

    private static Set<LottoNumber> convertToSet(String[] values) {
        Set<LottoNumber> numberSet = new HashSet<>();
        for (String value : values) {
            numberSet.add(LottoNumber.valueOf(value));
        }
        return numberSet;
    }

    public int matchCount(LottoNumbers lottoNumbers) {
        return (int) values.stream()
                .filter(lottoNumbers::isContain)
                .count();
    }

    public boolean isContain(LottoNumber lottoNumber) {
        return values.contains(lottoNumber);
    }

    public List<LottoNumber> toList() {
        return values.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(values, that.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }

    @Override
    public String toString() {
        return values.toString();
    }
}
