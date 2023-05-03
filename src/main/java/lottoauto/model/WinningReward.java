package lottoauto.model;

import java.util.Arrays;

public enum WinningReward {
    MATCH_3(3, 5000),
    MATCH_4(4, 50000),
    MATCH_5(5, 1500000),
    MATCH_6(6, 2000000000);

    private final int match;
    private final int reward;

    WinningReward(int match, int reward) {
        this.match = match;
        this.reward = reward;
    }

    public int getMatch() {
        return match;
    }

    public int getReward() {
        return reward;
    }

    public static WinningReward findRewardByMatches(int match) {
        return Arrays.stream(WinningReward.values())
                .filter(x -> x.match == match)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("일치하는 수가 없습니다."));
    }
}
