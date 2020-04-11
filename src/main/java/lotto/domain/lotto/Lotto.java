package lotto.domain.lotto;

import lotto.domain.rank.LottoRank;
import lotto.domain.rank.LottoTier;

import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;
import static lotto.domain.Constant.LOTTO_NUM_COUNT_LIMIT;

public class Lotto {
    private static final int LOTTO_MATCH_FIVE = 5;
    private final List<LottoNumber> lotto;

    private Lotto(List<Integer> lottoNumbers) {
        validate(lottoNumbers);
        List<LottoNumber> lotto = lottoNumbers.stream()
                .map(LottoNumber::of)
                .collect(toList());
        this.lotto = lotto;
    }

    public static Lotto of(List<Integer> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public LottoRank checkRank(List<Integer> winningNumbers, LottoNumber bonusNumber) {
        int matchCount = Long.valueOf(lotto.stream()
                .filter(lottoNumber -> lottoNumber.matches(winningNumbers))
                .count())
                .intValue();
        return getLottoRank(bonusNumber, matchCount);
    }

    public List<Integer> toIntValues() {
        return lotto.stream()
                .map(LottoNumber::intValue)
                .collect(toList());
    }

    private LottoRank getLottoRank(LottoNumber bonusNumber, int matchCount) {
        if (matchCount == LOTTO_MATCH_FIVE) {
            LottoTier lottoTier = LottoTier.of(matchCount, bonusNumber.matches(toIntValues()));
            return LottoRank.of(lottoTier);
        }
        LottoTier lottoTier = LottoTier.of(matchCount, false);
        return LottoRank.of(lottoTier);
    }

    private void validate(List<Integer> lottoNumbers) {
        if (isValidLottoSize(lottoNumbers)) {
            throw new LottoSizeException();
        }
    }

    private boolean isValidLottoSize(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .distinct()
                .count() != LOTTO_NUM_COUNT_LIMIT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lotto)) return false;
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }
}
