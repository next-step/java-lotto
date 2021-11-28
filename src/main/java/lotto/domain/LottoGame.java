package lotto.domain;

import java.util.Objects;

public class LottoGame {
    private Long matchedCount;
    private boolean matchBonus;
    private LottoNumbers lottoNumbers;

    public LottoGame(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
        this.matchBonus = false;
    }

    public LottoGame(Long matchedCount) {
        this.matchedCount = matchedCount;
    }

    public void matchLottoNumbers(LottoNumbers lastWeekWinningNumbers, BonusLottoNumber bonusLottoNumber) {
        matchedCount = lottoNumbers.getLottoNumbers().stream()
                .filter(lottoNumber -> lastWeekWinningNumbers.getLottoNumbers().contains(lottoNumber))
                .count();
        if (lottoNumbers.getLottoNumbers().contains(bonusLottoNumber)) {
            matchBonus = true;
        }
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }

    public Long getMatchedCount() {
        return matchedCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoGame lottoGame = (LottoGame) o;
        return matchBonus == lottoGame.matchBonus &&
                Objects.equals(matchedCount, lottoGame.matchedCount) &&
                Objects.equals(lottoNumbers, lottoGame.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchedCount, matchBonus, lottoNumbers);
    }
}
