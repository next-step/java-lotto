package lottery.domain;

import java.util.Arrays;

public enum Prize {
    LOSING_TICKET(0, 0),
    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    FIRST(6, 2_000_000_000),
    ;

    private final int condition;
    private final int winnings;

    Prize(int condition, int winnings) {
        this.condition = condition;
        this.winnings = winnings;
    }

    public static Prize getPrize(int matchedCount)  {
        return Arrays.stream(values())
                     .filter(p -> p.condition <= matchedCount)
                     .reduce((last, current) -> current)
                     .orElse(LOSING_TICKET);
    }

    public int getCondition() {
        return condition;
    }

    public int getWinnings() {
        return winnings;
    }
}
