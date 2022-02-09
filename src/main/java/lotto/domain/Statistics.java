package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum Statistics {
    FIRST(6, 2000000000),
    SECOND(7, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NONE2(2, 0),
    NONE1(1, 0),
    NONE(0, 0);

    public int getGrade() {
        return grade;
    }

    public int getMoney() {
        return money;
    }

    private final int grade;
    private final int money;

    Statistics(int grade, int money) {
        this.grade = grade;
        this.money = money;
    }

    public static Statistics getRank(int numberOfMatch) {
        return Arrays.stream(values())
            .filter(statistic -> statistic.grade == numberOfMatch)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException());
    }

    public static int getCount(List<Statistics> statistics, int matchCount) {
        return (int) statistics.stream()
            .filter(x -> x.grade == matchCount)
            .count();
    }
}
