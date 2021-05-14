package lotto;

import java.util.Arrays;

public enum Reward {
    SIXTH_PRIZE(0, false, 0),
    FIFTH_PRIZE(3, false, 5000),
    FOURTH_PRIZE(4, false, 50000),
    THIRD_PRIZE(5, false, 1500000),
    SECOND_PRIZE(5, true, 30000000),
    FIRST_PRIZE(6, false, 2000000000);

    private final int matchCount;
    private final boolean bonusBall;
    private final int prizeMoney;

    Reward(int matchCount, boolean bonusBall, int reward) {
        this.matchCount = matchCount;
        this.bonusBall = bonusBall;
        this.prizeMoney = reward;
    }

    public Integer getPrizeMoney() {
        return prizeMoney;
    }

    private int getMatchCount() {
        return this.matchCount;
    }

    public static Reward getReward(WinningLotto winningLotto) {
        if (winningLotto.bonusBall == true) {
            return Arrays.stream(Reward.values())
                    //질문사항 get 으로 가져오는거 vs 그냥 접근하는거 차이?, get 할때 return matchCount 랑 return this.matchCount 차이
                    .filter(reward -> reward.getMatchCount() == winningLotto.getMatchedCount())
                    .findAny()
                    .orElse(SIXTH_PRIZE);
        }
        return Arrays.stream(Reward.values())
                .filter(reward -> reward.getMatchCount() == winningLotto.getMatchedCount() && reward.bonusBall == reward.bonusBall)
                .findAny()
                .orElse(SIXTH_PRIZE);
    }
}
