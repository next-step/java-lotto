package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum ResultMap {

    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOUR(3, 5_000),
    ETC(0, 0);

    private int howMatch;
    private int prize;

    ResultMap(int howMatch, int prize) {
        this.howMatch = howMatch;
        this.prize = prize;
    }

    public static ResultMap of(int howMatch) {
        return Arrays.stream(values())
                .filter(resultMap -> resultMap.howMatch == howMatch)
                .findFirst()
                .orElse(ETC);
    }

    public static List<ResultMap> all() {
        return Arrays.asList(FOUR, THIRD, SECOND, FIRST);
    }

    public String showResult() {
        return String.format("%d개 일치 (%d원) ", howMatch, prize);
    }

    public int prize() {
        return prize;
    }
}
