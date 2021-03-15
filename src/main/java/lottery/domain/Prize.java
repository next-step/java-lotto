package lottery.domain;

import java.util.Arrays;

public enum Prize {

    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    LOSING_TICKET(0, 0)
    ;

    int condition;
    int winnings;

    Prize(int condition, int winnings) {
        this.condition = condition;
        this.winnings = winnings;
    }

    public static Prize getPrize(int matchedCount)  {
        return Arrays.stream(values())
                     .filter(p -> p.condition <= matchedCount)
                     .findFirst()
                     .orElse(LOSING_TICKET);
    }

    public int getWinnings() {
        return winnings;
    }
}
