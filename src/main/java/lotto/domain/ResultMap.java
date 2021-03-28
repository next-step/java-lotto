package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum ResultMap {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOUR(4, 50_000),
    FIVE(3, 5_000),
    ETC(0, 0);

    private int howMatch;
    private int prize;

    ResultMap(int howMatch, int prize) {
        this.howMatch = howMatch;
        this.prize = prize;
    }

    public static ResultMap of(int howMatch, boolean matchBonus) {
        ResultMap resultMap = Arrays.stream(values())
                .filter(result -> result.howMatch == howMatch)
                .findFirst()
                .orElse(ETC);
        if (resultMap == SECOND && !matchBonus) {
            return THIRD;
        }
        return resultMap;
    }

    public static List<ResultMap> winningResults() {
        return Arrays.asList(FIVE, FOUR, THIRD, SECOND, FIRST);
    }

    public String showResult() {
        return String.format("%d개 일치 (%d원) ", howMatch, prize);
    }

    public int prize() {
        return prize;
    }
}
