package step2.domain.enums;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000);

    private final static Map<Integer, String> map = Stream.of(values()).collect(Collectors.toMap(Rank::getCorrectCount, Rank::name));
    private final int correctCount;
    private final int prizeMoney;

    Rank(int correctCount, int money) {
        this.correctCount = correctCount;
        this.prizeMoney = money;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static Rank of(int count) {
        if (map.containsKey(count)) {
            return Rank.valueOf(map.get(count));
        }
        return null;
    }
}
