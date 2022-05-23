package domain;

import java.util.Objects;

public class Winner {
    private final LottoNumbers lottoNumbers;

    public Winner(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public Rank match(Lotto lotto) {
        int matchCount = lotto.countMatch(lottoNumbers);
        return Rank.of(matchCount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Winner winner = (Winner) o;
        return lottoNumbers.equals(winner.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
