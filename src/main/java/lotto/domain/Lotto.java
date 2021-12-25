package lotto.domain;

import lotto.domain.stat.LottoRank;
import lotto.exception.LottoGameException;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Lotto {

    private static final String LOTTO_NUMBERS_COUNT_EXCEPTION_MESSAGE = "로또 숫자는 6개이어야 합니다.";

    public static final int LOTTO_NUMBERS_COUNT = 6;

    private final Set<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        this(new HashSet<>(lottoNumbers));
    }

    public Lotto(Set<LottoNumber> lottoNumbers) {
        checkLottoNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void checkLottoNumbers(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBERS_COUNT) {
            throw new LottoGameException(LOTTO_NUMBERS_COUNT_EXCEPTION_MESSAGE);
        }
    }

    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public LottoRank calculateRank(Lotto winningLotto) {
        int matchedNumberCount  = (int) lottoNumbers.stream()
                .filter(winningLotto::contains)
                .count();

        return LottoRank.of(matchedNumberCount);
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
