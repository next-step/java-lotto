package lotto.domain;

public class LottoWinningResult {
    private final LottoRank rank;
    private final LottoBundle winningLottoBundle;

    public LottoWinningResult(final LottoRank rank, final LottoBundle winningLottoBundle) {
        this.rank = rank;
        this.winningLottoBundle = winningLottoBundle;
    }

    public boolean isRankMatch(final LottoRank rank) {
        return rank.equals(this.rank);
    }

    public int size() {
        return winningLottoBundle.size();
    }

    public long totalWinningPrice() {
        return (long) rank.getWinningPrice() * winningLottoBundle.size();
    }
}
