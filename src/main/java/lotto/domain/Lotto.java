package lotto.domain;

import lotto.domain.exception.InvalidLottoSizeException;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    public static final int LOTTO_NUMBER_SIZE = 6;

    private final Set<LottoNumber> lottoNumberSet;

    public Lotto(Set<LottoNumber> lottoNumberSet) {
        checkLottoNumbers(lottoNumberSet);

        this.lottoNumberSet = lottoNumberSet;
    }

    public Set<LottoNumber> getLottoNumberSet() {
        return Set.copyOf(lottoNumberSet);
    }

    public boolean hasNumber(LottoNumber number) {
        return lottoNumberSet.contains(number);
    }

    private void checkLottoNumbers(Set<LottoNumber> lottoNumberSet) {
        if (lottoNumberSet.size() != LOTTO_NUMBER_SIZE) {
            throw new InvalidLottoSizeException(
                    "입력한 갯수 : ",
                    String.valueOf(lottoNumberSet.size())
            );
        }
    }

    public static Lotto from(Set<Integer> lottoNumberSet) {
        return new Lotto(lottoNumberSet.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet())
        );
    }

    public static Lotto from(String lottoNumberString) {
        return new Lotto(Arrays.stream(lottoNumberString.split(","))
                .map(it -> LottoNumber.from(it.trim()))
                .collect(Collectors.toSet())
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumberSet, lotto.lottoNumberSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumberSet);
    }
}
