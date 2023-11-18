package lotto.domain;

public class LottoWinResult {
    private final long matchCount;
    private final long prizeAmount;
    private final long winCount;
    private final boolean isBonus;

    public LottoWinResult(long matchCount, long winCount, boolean isBonus) {
        this.matchCount = matchCount;
        this.prizeAmount = LottoRank.prizeAmount((int) matchCount, isBonus);
        this.winCount = winCount;
        this.isBonus = isBonus;
    }

    public long income() {
        return prizeAmount * winCount;
    }

    public long getMatchCount() {
        return matchCount;
    }

    public long getPrizeAmount() {
        return prizeAmount;
    }

    public long getWinCount() {
        return winCount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getMatchCount() + "개 일치");
        if (isBonus) {
            sb.append(", 보너스 볼 일치");
        }
        sb.append("(" + getPrizeAmount() + "원" + ") - " + getWinCount() + "개");
        return sb.toString();
    }
}
