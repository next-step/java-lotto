package lotto.constants;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public enum Winning {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    FAIL(0, 0);

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

    public static Set<Winning> prizeWinning() {
        return new LinkedHashSet<>() {{
            add(FIFTH);
            add(FOURTH);
            add(THIRD);
            add(SECOND);
            add(FIRST);
        }};
    }

    public long prize() {
        return prize;
    }

    public long matchCount() {
        return matchCount;
    }
}
