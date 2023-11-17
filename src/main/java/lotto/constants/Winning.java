package lotto.constants;

import java.util.HashMap;
import java.util.Map;

public enum Winning {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    FAIL(0, 0);

    static final Map<Long, Winning> winnings = new HashMap<>();

    private static final String MESSAGE = "%s개 일치 (%s원)";

    private final String message;
    private final long matchCount;
    private final long prize;

    Winning(long matchCount, long prize) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.message = String.format(MESSAGE, matchCount, prize);
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

    public String message() {
        return message;
    }

    public long prize() {
        return prize;
    }
}
