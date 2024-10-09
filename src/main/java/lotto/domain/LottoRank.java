package lotto.domain;

import java.util.Objects;

public class LottoRank {
    public final static int FIRST_RANK_MATCH_NUMBER = 6;
    public final static int THIRD_RANK_MATCH_NUMBER = 5;
    public final static int FOURTH_RANK_MATCH_NUMBER = 4;
    public final static int FIFTH_RANK_MATCH_NUMBER = 3;

    private final int rank;
    private final int winningPrice;

    private LottoRank(final int rank,
                      final int winningPrice) {
        this.rank = rank;
        this.winningPrice = winningPrice;
    }

    public static LottoRank first() {
        return new LottoRank(1, 2_000_000_000);
    }

    public static LottoRank third() {
        return new LottoRank(3, 1_500_000);
    }

    public static LottoRank fourth() {
        return new LottoRank(4, 50_000);
    }

    public static LottoRank fifth() {
        return new LottoRank(5, 5_000);
    }

    public static LottoRank none() {
        return new LottoRank(0, 0);
    }

    public int getWinningPrice() {
        return winningPrice;
    }

    public static LottoRank findLottoRankByMatchedCount(final long matchedCount) {
        if (matchedCount == FIRST_RANK_MATCH_NUMBER) {
            return first();
        }

        if (matchedCount == THIRD_RANK_MATCH_NUMBER) {
            return third();
        }

        if (matchedCount == FOURTH_RANK_MATCH_NUMBER) {
            return fourth();
        }

        if (matchedCount == FIFTH_RANK_MATCH_NUMBER) {
            return fifth();
        }

        return none();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(rank);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        final LottoRank lottoRank = (LottoRank) obj;
        return rank == lottoRank.rank;
    }
}
