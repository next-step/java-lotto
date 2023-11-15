package lotto.domain;

public class LottoWinResult {
    private long machCount;
    private long prizeAmount;
    private long winCount;

    public LottoWinResult(long machCount, long winCount) {
        this.machCount = machCount;
        this.prizeAmount = LottoPrice.prizeAmount((int) machCount);
        this.winCount = winCount;
    }

    public long income(){
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
}
