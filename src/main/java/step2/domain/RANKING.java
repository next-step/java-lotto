package step2.domain;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum RANKING {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    UNKNOWN(0, 0);

    private final static Map<Integer, String> map = Stream.of(values()).collect(Collectors.toMap(RANKING::getCorrectCount, RANKING::name));
    private final int correctCount;
    private final int prizeMoney;

    RANKING(int correctCount, int money) {
        this.correctCount = correctCount;
        this.prizeMoney = money;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static RANKING of(int count) {
        if (map.containsKey(count)) {
            return RANKING.valueOf(map.get(count));
        }

        return RANKING.UNKNOWN;
    }
}
