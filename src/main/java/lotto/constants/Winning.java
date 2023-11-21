package lotto.constants;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum Winning {
    FAIL(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    static final Map<Long, Winning> winnings = new HashMap<>();


    private final long matchCount;
    private final long prize;

    Winning(long matchCount, long prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    static {
        initialize();
    }

    private static void initialize() {
        for (Winning value : values()) {
            winnings.put(value.matchCount, value);
        }
    }

    public static Winning of(long matchCount, boolean bonusMatch) {
        if (matchCount == 5 && bonusMatch) {
            return SECOND;
        }

        return winnings.getOrDefault(matchCount, FAIL);
    }

    public static EnumSet<Winning> prizeWinning() {
        EnumSet<Winning> result = EnumSet.allOf(Winning.class);
        result.remove(FAIL);
        return result;
    }

    public long prize() {
        return prize;
    }

    public long matchCount() {
        return matchCount;
    }
}
