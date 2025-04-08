package step2.winning;

import java.util.Arrays;

public enum Winning {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    NONE(0, 0, false);

    private final int matchCount;
    private final int prize;
    private final boolean matchBonus;

    Winning(int matchCount, int prize, boolean matchBonus) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.matchBonus = matchBonus;
    }
    public int getPrize() {
        return prize;
    }
    public static Winning valueOf(int matchCount, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(winning -> winning.matchCount == matchCount && winning.matchBonus == matchBonus)
                .findFirst()
                .orElse(NONE);
    }
}
