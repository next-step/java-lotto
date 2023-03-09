package domain;

import java.util.Arrays;

public enum LottoReward {

    // THREE("3개 일치", "5000원"),
    // FOUR("4개 일치", "50000원"),
    // FIVE("5개 일치", "1500000원"),
    // FIVE_WITH_BONUS("5개 일치, 보너스 볼 일치", "30000000원"),
    // SIX("6개 일치", "2000000000원");

    // THREE("3개 일치", "5000원"),
    // FOUR("4개 일치", "50000원"),
    // FIVE("5개 일치", "1500000원"),
    // // FIVE("5개 일치, 보너스 볼 일치", "30000000원"),
    // SIX("6개 일치", "2000000000원");

    THREE(3),
    // {
    // public LottoRankAmount getRankAmount(int matchCount, boolean lottoBounusYn) {
    // return Arrays.stream(LottoRankAmount.values())
    // .filter(lottoRankAmount ->
    // lottoRankAmount.getAmountByRank(getRank(matchCount, lottoBounusYn)))
    // .findFirst()
    // .get();

    // }

    // },
    FOUR(4),
    FIVE(5),
    SIX(6);

    private int matchCount;
    private LottoBonusState bonusState;
    private LottoRankAmount rankAmount;

    private LottoReward(int matchCount) {
        this.matchCount = matchCount;
    }

    private int getRank(int matchCount, boolean lootoBounusYn) {
        return 1;
    }
    // private LottoBonusYn bonusYn;
    // private LottoRankAmount amount;

    // private LottoReward(String rewardCount, String rewardAmount) {
    // this.rewardCount = rewardCount;
    // this.rewardAmount = rewardAmount;
    // }

    // public String getRewardCount() {
    // return this.rewardCount;
    // }

    // public String getRewardAmount() {
    // return this.rewardAmount;
    // }
}