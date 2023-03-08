package domain;

public enum LottoReward {
    THREE("3개 일치", "5000원"),
    FOUR("4개 일치", "50000원"),
    FIVE("5개 일치", "1500000원"),
    FIVE_WITH_BONUS("5개 일치, 보너스 볼 일치", "30000000원"),
    SIX("6개 일치", "2000000000원");

    private String rewardCount;
    private String rewardAmount;

    private LottoReward(String rewardCount, String rewardAmount) {
        this.rewardCount = rewardCount;
        this.rewardAmount = rewardAmount;
    }

    public String getRewardCount() {
        return this.rewardCount;
    }

    public String getRewardAmount() {
        return this.rewardAmount;
    }
}