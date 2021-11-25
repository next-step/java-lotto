package lotto.domain;

import java.util.Objects;

public class LottoGame {
    private Long matchedCount;
    private LottoNumbers lottoNumbers;

    public LottoGame(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public void matchLottoNumbers(LottoNumbers lastWeekWinningNumbers) {
        matchedCount = lottoNumbers.getLottoNumbers().stream()
                .filter(lottoNumber -> lastWeekWinningNumbers.getLottoNumbers().contains(lottoNumber))
                .count();
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoGame lottoGame = (LottoGame) o;
        return Objects.equals(matchedCount, lottoGame.matchedCount) &&
                Objects.equals(lottoNumbers, lottoGame.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchedCount, lottoNumbers);
    }
}
