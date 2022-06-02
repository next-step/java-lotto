package domain;

import java.util.Objects;

public class Winner {
    private final LottoNumbers winnerNumbers;
    private final BonusNumber bonusNumber;

    public Winner(LottoNumbers winnerNumbers, BonusNumber bonusNumber) {
        this.winnerNumbers = winnerNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Rank match(Lotto lotto) {
        int matchCount = lotto.countMatch(winnerNumbers);
        return Rank.of(matchCount);
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
