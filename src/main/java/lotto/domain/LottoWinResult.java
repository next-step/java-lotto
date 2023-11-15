package lotto.domain;

public class LottoWinResult {
    private long machCount;
    private long prizeAmount;
    private long winCount;
    private boolean isBonus;

    public LottoWinResult(long machCount, long winCount, boolean isBonus) {
        this.machCount = machCount;
        this.prizeAmount = LottoRank.prizeAmount((int) machCount, isBonus);
        this.winCount = winCount;
        this.isBonus = isBonus;
    }

    public long income() {
        return prizeAmount * winCount;
    }

    public long getMachCount() {
        return machCount;
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
        sb.append(getMachCount() + "개 일치");
        if (isBonus) {
            sb.append(", 보너스 볼 일치");
        }
        sb.append("(" + getPrizeAmount() + "원" + ") - " + getWinCount() + "개");
        return sb.toString();
    }
}
