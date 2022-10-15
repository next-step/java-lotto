package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoNumberSet {

    private final Set<LottoNumber> lottoNumberSet;
    public static int LOTTO_SIZE = 6;
    private static final String LOTTO_SIZE_EXCEPTION = "로또 번호는 " + LOTTO_SIZE + "개여야 합니다.";

    public static LottoNumberSet createLottoNumberSet(int... numbers) {
        return new LottoNumberSet(Arrays.stream(numbers)
                .mapToObj(number -> new LottoNumber(number))
                .collect(Collectors.toSet()));
    }

    public static LottoNumberSet createLottoNumberSet() {
        return new LottoNumberSet(LottoNumberFactory.getNumbers(LOTTO_SIZE));
    }

    public LottoNumberSet(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_SIZE_EXCEPTION);
        }
        this.lottoNumberSet = lottoNumbers;
    }

    public int match(LottoNumberSet numbers) {
        return lottoNumberSet.stream()
                .filter(lottoNumber -> numbers.lottoNumberSet().contains(lottoNumber))
                .collect(Collectors.toList())
                .size();
    }

    private Set<LottoNumber> lottoNumberSet() {
        return Collections.unmodifiableSet(this.lottoNumberSet);
    }

    public boolean contain(LottoNumber lottoNumber) {
        return lottoNumberSet.contains(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumberSet that = (LottoNumberSet) o;
        return Objects.equals(lottoNumberSet, that.lottoNumberSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumberSet);
    }

    @Override
    public String toString() {
        return lottoNumberSet.stream()
                .sorted(Comparator.comparingInt(LottoNumber::number))
                .map(lottoNumber -> lottoNumber.toString())
                .collect(Collectors.joining(", "));
    }
}
