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

    /**
     * 로또 번호가 일치하는 갯수를 리턴한다.
     *
     * @param lotto 비교하고자는 로또
     * @return 숫자가 일치하는 갯수
     */
    public int getLottoMatchCount(Lotto lotto) {
        return Math.toIntExact(lottoNumbers.stream()
                .filter(lotto::isMatch)
                .count());
    }

    private boolean isMatch(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
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
