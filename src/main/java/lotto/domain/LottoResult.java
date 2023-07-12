package lotto.domain;

import java.util.Objects;

public class LottoResult {

    private final int rank;
    private final int prize;

    public LottoResult(final LottoRule lottoRule) {
        this(lottoRule.getRank(), lottoRule.getPrize());
    }

    public LottoResult(final int rank, final int prize) {
        this.rank = rank;
        this.prize = prize;
    }

    public int getRank() {
        return this.rank;
    }

    public int getPrize() {
        return this.prize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoResult that = (LottoResult) o;
        return rank == that.rank && prize == that.prize;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, prize);
    }
}
