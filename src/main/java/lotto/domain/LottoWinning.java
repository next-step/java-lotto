package lotto.domain;

public enum LottoWinning {

    FAIL(0, 0),
    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    FIRST(6, 2_000_000_000);

    private int matchCount;
    private int reward;

    LottoWinning(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static LottoWinning getWinningStatus(int matchCount) {
        for (LottoWinning status : LottoWinning.values()) {
            if (matchCount == status.getMatchCount()) {
                return status;
            }
        }
        return FAIL;
    }

    private int getMatchCount() {
        return this.matchCount;
    }

    public int getReward() {
        return this.reward;
    }

    public String getWinningStatusStr() {
        return this.matchCount + "개 일치 (" + this.reward + "원)- ";
    }

}
