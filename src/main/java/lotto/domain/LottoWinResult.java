package lotto.domain;

public class LottoWinResult {
    private static final long THREE_MATCH_PRIZE_AMOUNT = 5000;
    private static final long FOUR_MATCH_PRIZE_AMOUNT = 50000;
    private static final long FIVE_MATCH_PRIZE_AMOUNT = 1500000;
    private static final long SIX_MATCH_PRIZE_AMOUNT = 2000000000;

    private long machCount;
    private long prizeAmount;
    private long winCount;

    public LottoWinResult(long machCount, long winCount) {
        this.machCount = machCount;
        this.prizeAmount = prizeAmount((int) machCount);
        this.winCount = winCount;
    }

    private long prizeAmount(int machCount) {
        switch (machCount) {
            case 3:
                return THREE_MATCH_PRIZE_AMOUNT;
            case 4:
                return FOUR_MATCH_PRIZE_AMOUNT;
            case 5:
                return FIVE_MATCH_PRIZE_AMOUNT;
            case 6:
                return SIX_MATCH_PRIZE_AMOUNT;
            default:
                return 0;
        }
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
