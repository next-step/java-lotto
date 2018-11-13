package domain;

public class LottoResult {
    private boolean isBonus;
    private Integer combineCount;

    public LottoResult(Integer combineCount, boolean isBonus) {
        this.combineCount = combineCount;
        this.isBonus = isBonus;
    }

    public int getReward() {
        return LottoRank.valueOf(combineCount, isBonus).getPriceRewards();
    }

    public boolean getCombineLotto(int combineNum, boolean isBonus) {
        return combineCount.equals(combineNum) && this.isBonus == isBonus;
    }
}
