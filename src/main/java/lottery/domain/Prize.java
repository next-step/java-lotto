package lottery.domain;

import java.util.Arrays;

public enum Prize {
    LOSING_TICKET(0, 0),
    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    FIRST(6, 2_000_000_000),
    ;

    private final long condition;
    private final long winnings;

    Prize(long condition, long winnings) {
        this.condition = condition;
        this.winnings = winnings;
    }

    public static Prize getPrize(long matchedCount)  {
        return Arrays.stream(values())
                     .filter(p -> p.condition == matchedCount)
                     .findFirst()
                     .orElse(LOSING_TICKET);
    }

    public long getCondition() {
        return condition;
    }

    public long getWinnings() {
        return winnings;
    }
}
