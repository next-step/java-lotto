package lotto.domain;

public class LottoWinningResult {
    private final LottoRank rank;
    private final LottoResultBundle winningLottoBundle;

    public LottoWinningResult(final LottoRank rank, final LottoResultBundle winningLottoBundle) {
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
        return rank.calculateWinningPrice(winningLottoBundle.size());
    }
}
