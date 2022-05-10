package lotto.domain;

import lotto.exception.InvalidLottoNumberCount;
import lotto.generator.RandomNumberGenerator;

import java.util.*;
import java.util.stream.Collectors;

public class LottoNumbers {

    public static final int LOTTO_NUMBER_COUNT = 6;

    private final Set<LottoNumber> values;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this(new TreeSet<>(lottoNumbers));
    }

    public LottoNumbers(TreeSet<LottoNumber> lottoNumberTreeSet) {
        if (lottoNumberTreeSet.size() != LOTTO_NUMBER_COUNT) {
            throw new InvalidLottoNumberCount();
        }
        this.values = lottoNumberTreeSet;
    }

    public static LottoNumbers createWinningNumbers(String[] winningNumberValues) {
        TreeSet<LottoNumber> winningNumberTreeSet = new TreeSet<>();
        for (String value : winningNumberValues) {
            winningNumberTreeSet.add(LottoNumber.valueOf(value));
        }
        return new LottoNumbers(winningNumberTreeSet);
    }

    public static LottoNumbers createRandomLottoNumbers() {
        List<LottoNumber> randomLottoNumbers = RandomNumberGenerator.generate()
                .stream()
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());
        return new LottoNumbers(randomLottoNumbers);
    }

    public int matchCount(LottoNumbers lottoNumbers) {
        return (int) values.stream()
                .filter(lottoNumbers::isContain)
                .count();
    }

    public boolean isContain(LottoNumber lottoNumber) {
        return values.contains(lottoNumber);
    }

    public Set<LottoNumber> toSet() {
        return values;
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
