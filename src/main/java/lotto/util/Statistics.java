package lotto.util;

import java.util.Arrays;

public enum Statistics {
    FIRST(6, 2000000000),
    SECOND(5, 30000000), // 이게 보너스볼
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NONE1(1,0),
    NONE2(2,0),
    NONE(0,0);

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
}
