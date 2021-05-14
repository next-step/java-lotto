package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Reward {
    SIXTH_PRIZE(0, 0, 0),
    FIFTH_PRIZE(3, 0, 5000),
    FOURTH_PRIZE(4, 0, 50000),
    THIRD_PRIZE(5, 0, 1500000),
    SECOND_PRIZE(5, 1, 30000000),
    FIRST_PRIZE(6, 0, 2000000000);

    private final int matchCount;
    private final int bonusCount;
    private final int prizeMoney;

    Reward(int matchCount, int bonusMatch, int reward) {
        this.matchCount = matchCount;
        this.bonusCount = bonusMatch;
        this.prizeMoney = reward;
    }

    public Integer getPrizeMoney() {
        return prizeMoney;
    }

    private List<Integer> getMatchCounts() {
        List<Integer> matchCounts = new ArrayList<>();
        matchCounts.add(matchCount);
        matchCounts.add(bonusCount);
        return matchCounts;
    }

    public static Reward getReward(List<Integer> matchCounts) {
            return Arrays.stream(Reward.values())
                    .filter(reward -> reward.getMatchCounts().equals(matchCounts))
                    .findAny()
                    .orElse(SIXTH_PRIZE);
    }
}
