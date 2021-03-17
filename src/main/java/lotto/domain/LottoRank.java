package lotto.domain;

public class LottoRank {
    private final int winnerCount;
    private final Rank rank;

    public LottoRank(Rank rank, LottoMachine lottoMachine, WinnerNumber winnerNumber) {
        this.rank = rank;
        this.winnerCount = rank.rankCount(lottoMachine, winnerNumber);
    }

    public Rank getRank() {
        return rank;
    }

    public int getWinnerCount() {
        return winnerCount;
    }
}
