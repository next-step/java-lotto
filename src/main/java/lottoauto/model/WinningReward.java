package lottoauto.model;

import java.util.Arrays;

public enum WinningReward {

    NONE(0, 0, false),
    MATCH_1(1, 0, false),
    MATCH_2(2, 0, false),
    MATCH_3(3, 5000, false),
    MATCH_4(4, 50000, false),
    MATCH_5(5, 1500000, false),
    MATCH_5_BONUS(5, 30000000, true),
    MATCH_6(6, 2000000000, false);

    private final int matchCount;
    private final int reward;
    private final boolean bonus;

    WinningReward(int matchCount, int reward, boolean bonus) {
        this.matchCount = matchCount;
        this.reward = reward;
        this.bonus = bonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }

    public boolean getBonus() {
        return bonus;
    }

    public static WinningReward findRewardByMatches(int match) {
        return Arrays.stream(WinningReward.values())
                .filter(x -> x.matchCount == match)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("일치하는 수가 없습니다."));
    }

}
