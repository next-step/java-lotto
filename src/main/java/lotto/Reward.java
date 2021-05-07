package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public enum Reward {
    MATCH_3(3, 0, 5000),
    MATCH_4(4, 0, 50000),
    MATCH_5(5, 0, 1500000),
    MATCH_6_WITH_BONUS(5, 1, 30000000),
    MATCH_6(6, 0, 2000000000);

    private final Integer matchCount;
    private final Integer bonusCount;
    private final Integer prizeMoney;

    Reward(Integer matchCount, Integer bonusCount, Integer reward) {
        this.matchCount = matchCount;
        this.bonusCount = bonusCount;
        this.prizeMoney = reward;
    }

    public Integer getPrizeMoney() {
        return prizeMoney;
    }

    public List<Integer> getMatchCounts() {
        List<Integer> mathCounts = new ArrayList<>();
        mathCounts.add(matchCount);
        mathCounts.add(bonusCount);
        return mathCounts;
    }

    public static Reward getReward(List<Integer> matchCounts) {
        return Arrays.stream(Reward.values())
                .filter(reward -> reward.getMatchCounts().toString().equals(matchCounts.toString()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException());
    }
}
