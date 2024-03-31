package lotto.domain;

import java.util.Arrays;

public enum WinningInfo {
    THREE_MATCHES(3, 5_000),
    FOUR_MATCHES(4, 50_000),
    FIVE_MATCHES(5, 1_500_000),
    SIX_MATCHES(6, 2_000_000_000),
    NONE_MATCHES(0, 0);

    private final int matches;
    private final long reward;

    WinningInfo(int matches, long reward) {
        this.matches = matches;
        this.reward = reward;
    }

    public long getReward(){
        return this.reward;
    }
    public int getMatches() {
        return matches;
    }

    public static WinningInfo checkMatch(long matches){
        return Arrays.stream(WinningInfo.values())
                .filter(winningInfo -> winningInfo.matches == matches)
                .findFirst()
                .orElse(NONE_MATCHES);
    }
}
