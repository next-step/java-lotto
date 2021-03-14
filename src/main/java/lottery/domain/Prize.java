package lottery.domain;

import java.util.Arrays;

public enum Prize {

    FIRST(6),
    SECOND(5),
    THIRD(4),
    FOURTH(3),
    FIFTH(2),
    LOSING_TICKET(0)
    ;

    int condition;

    Prize(int condition) {
        this.condition = condition;
    }

    public static Prize getPrize(int matchedCount)  {
        return Arrays.stream(values())
                     .filter(p -> p.condition <= matchedCount)
                     .findFirst()
                     .orElse(LOSING_TICKET);
    }

}
