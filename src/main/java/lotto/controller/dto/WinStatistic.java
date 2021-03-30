package lotto.controller.dto;

public class WinStatistic {

    private final int rankCount;
    private final long winAmount;
    private final int matchLottoCount;
    private final boolean matchBonus;

    public WinStatistic(int rankCount, long winAmount, int matchLottoCount, boolean matchBonus) {
        this.rankCount = rankCount;
        this.winAmount = winAmount;
        this.matchLottoCount = matchLottoCount;
        this.matchBonus = matchBonus;
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

    public boolean isMatchBonus() {
        return matchBonus;
    }
}
