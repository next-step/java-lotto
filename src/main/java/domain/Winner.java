package domain;

import java.util.Objects;

public class Winner {
    private final LottoNumbers winnerNumbers;
    private final BonusNumber bonusNumber;

    public Winner(LottoNumbers winnerNumbers, BonusNumber bonusNumber) {
        validateDuplicateBonusNumber(winnerNumbers, bonusNumber);

        this.winnerNumbers = winnerNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Rank match(Lotto lotto) {
        int matchCount = lotto.countMatch(winnerNumbers);
        return Rank.of(matchCount);
    }

    private void validateDuplicateBonusNumber(LottoNumbers winnerNumbers, BonusNumber bonusNumber) {
        if (winnerNumbers.match(bonusNumber.toLottoNumber())) {
            throw new IllegalArgumentException("보너스 볼은 로또 번호와 중복될 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Winner winner = (Winner) o;
        return winnerNumbers.equals(winner.winnerNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winnerNumbers);
    }
}
