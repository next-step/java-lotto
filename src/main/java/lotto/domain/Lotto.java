package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/**
 * 로또.
 */
public class Lotto {
    private static final String LOTTO_COUNT_NOT_MATCH = "로또 갯수가 일치하지 않습니다.";
    private static final String DUPLICATED_BONUS_NUMBER = "당첨 번호와 보너스 번호가 중복되었습니다.";
    private static int MAX_LOTTO_COUNT = 6;
    private final Set<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = validate(lottoNumbers);
    }

    private Set<LottoNumber> validate(List<LottoNumber> lottoNumbers) {
        if (getDistinctCount(lottoNumbers) != MAX_LOTTO_COUNT) {
            throw new IllegalArgumentException(LOTTO_COUNT_NOT_MATCH);
        }
        return new TreeSet<>(lottoNumbers);
    }

    private int getDistinctCount(List<LottoNumber> lottoNumbers) {
        return Math.toIntExact(lottoNumbers.stream()
                .distinct()
                .count());
    }

    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    /**
     * 주어진 로또와 우승 로또를 비교하여 상금을 리턴한다.
     *
     * @param winningLotto 당첨 로또
     * @param bonusNumber  보너스 숫자
     * @return 상금
     */
    public Prize getPrizeMatch(final Lotto winningLotto, final LottoNumber bonusNumber) {
        int matchCount = getLottoMatchCount(winningLotto);
        if (winningLotto.isMatch(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED_BONUS_NUMBER);
        }
        boolean isBonusNumberMatch = this.isMatch(bonusNumber);
        return Prize.of(matchCount, isBonusNumberMatch);
    }

    private int getLottoMatchCount(Lotto winningLotto) {
        return Math.toIntExact(lottoNumbers.stream()
                .filter(winningLotto::isMatch)
                .count());
    }

    private boolean isMatch(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lotto)) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(getLottoNumbers(), lotto.getLottoNumbers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLottoNumbers());
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumbers);
    }
}
