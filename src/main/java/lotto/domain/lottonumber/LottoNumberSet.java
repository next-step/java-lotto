package lotto.domain.lottonumber;

import lotto.domain.LottoMatchCount;

import java.util.*;
import java.util.stream.Collectors;

public class LottoNumberSet {

    private final Set<LottoNumber> lottoNumberSet;
    private static final int LOTTO_SET_SIZE = 6;
    public static final String LOTTONUMBERSET_DELIMITER = ", ";

    private static final String LOTTO_SIZE_EXCEPTION = "로또 번호는 " + LOTTO_SET_SIZE + "개여야 합니다.";

    public static LottoNumberSet createLottoNumberSet(final int... numbers) {
        return new LottoNumberSet(Arrays.stream(numbers)
                .mapToObj(number -> new LottoNumber(number))
                .collect(Collectors.toSet()));
    }

    public static LottoNumberSet createLottoNumberSet() {
        return new LottoNumberSet(LottoNumberFactory.getNumbers(LOTTO_SET_SIZE));
    }

    public LottoNumberSet(final Set<LottoNumber> lottoNumbers) {
        if (checkLottoNumberSize(lottoNumbers)) {
            throw new IllegalArgumentException(LOTTO_SIZE_EXCEPTION);
        }
        this.lottoNumberSet = lottoNumbers;
    }

    private static boolean checkLottoNumberSize(final Set<LottoNumber> lottoNumbers) {
        return lottoNumbers.size() != LOTTO_SET_SIZE;
    }

    public LottoMatchCount match(final LottoNumberSet numbers) {
        return new LottoMatchCount(lottoNumberSet.stream()
                .filter(lottoNumber -> numbers.lottoNumberSet().contains(lottoNumber))
                .collect(Collectors.toList())
                .size());
    }

    public boolean contain(final LottoNumber lottoNumber) {
        return lottoNumberSet.contains(lottoNumber);
    }

    private Set<LottoNumber> lottoNumberSet() {
        return Collections.unmodifiableSet(this.lottoNumberSet);
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
                .collect(Collectors.joining(LOTTONUMBERSET_DELIMITER));
    }
}
