package lotto.domain;

import java.nio.channels.Pipe;
import java.util.Arrays;
import java.util.List;

public enum Prize {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    ETC(0, 0);

    private final long matchCount;
    private final int reward;

    private Prize(long matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static Prize valueOf(Long matchCount, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(prize -> prize.matchCount == matchCount)
                .filter(prize -> checkBonusValid(prize, matchBonus))
                .findAny()
                .orElse(Prize.ETC);
    }

    private static boolean checkBonusValid(Prize prize, boolean matchBonus) {
        if (isMatchCount5(prize)) {
            return prize.equals(Prize.SECOND) == matchBonus;
        }
        return true;
    }

    private static boolean isMatchCount5(Prize prize) {
        return prize.equals(Prize.SECOND) || prize.equals(Prize.THIRD);
    }

    public static List<Prize> valuesOfWin() {
        return Arrays.asList(Prize.FIFTH, Prize.FOURTH, Prize.THIRD, Prize.SECOND, Prize.FIRST);
    }

    public long getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }
}
