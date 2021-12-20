package step2.domain.enums;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 3_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000);

    private final static Map<String, Integer> map = Stream.of(values()).collect(Collectors.toMap(Rank::name, Rank::getCorrectCount));
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

    public static Rank of(int count, boolean isCorrectBonusNumber) {
        if (count == SECOND.getCorrectCount() && isCorrectBonusNumber) {
            return SECOND;
        }
        if (count == FIRST.getCorrectCount())  return FIRST;
        if (count == THIRD.getCorrectCount())  return THIRD;
        if (count == FOURTH.getCorrectCount())  return FOURTH;
        if (count == FIFTH.getCorrectCount())  return FIFTH;

        return null;
    }
}
