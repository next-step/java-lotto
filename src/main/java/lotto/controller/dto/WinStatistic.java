package lotto.controller.dto;

public class WinStatistic {

    private final int rankCount;
    private final long winAmount;
    private final int matchLottoCount;

    public WinStatistic(int rankCount, long winAmount, int matchLottoCount) {
        this.rankCount = rankCount;
        this.winAmount = winAmount;
        this.matchLottoCount = matchLottoCount;
    }

    public int getRankCount() {
        return rankCount;
    }

    public long getWinAmount() {
        return winAmount;
    }

    public int getMatchLottoCount() {
        return matchLottoCount;
    }
}
