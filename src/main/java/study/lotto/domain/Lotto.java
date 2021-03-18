package study.lotto.domain;

import study.lotto.domain.type.LottoMatch;
import study.lotto.view.dto.RequestWinningNumber;

import java.util.List;
import java.util.Objects;

/**
 * 하나의 로또 게임 하나
 */
public class Lotto {

    private final List<LottoNumber> lottoNumbers;

    public Lotto(final List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public long winningReward(final RequestWinningNumber requestWinningNumber, LottoNumber hasBonusNumber) {
        return match(requestWinningNumber, hasBonusNumber).getWinningReward();
    }

    public LottoMatch match(final RequestWinningNumber winningNumber, LottoNumber hasBonusNumber) {

        long count = lottoNumbers.stream()
                .filter(winningNumber::contains)
                .count();

        boolean hasBonus = lottoNumbers.stream()
                .anyMatch(lottoNumber -> lottoNumber.equals(hasBonusNumber));

        return LottoMatch.of(count, hasBonus);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto1.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumbers);
    }
}
