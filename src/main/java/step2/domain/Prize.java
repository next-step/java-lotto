package step2.domain;

import java.util.Arrays;
import java.util.function.Predicate;

public enum Prize {
    FIRST(1, 2000000000, 6, false),
    SECOND(2, 30000000, 5, true),
    THIRD(3, 1500000, 5, false),
    FORTH(4, 50000, 4, false),
    FIFTH(5, 5000, 3, false),
    NONE(0, 0, 0, false),
    ;

    private int grade;
    private int cashPrize;
    private int hitCount;
    private boolean isMatchedBonus;

    Prize(int grade, int cashPrize, int hitCount, boolean isMatchedBonus) {
        this.grade = grade;
        this.cashPrize = cashPrize;
        this.hitCount = hitCount;
        this.isMatchedBonus = isMatchedBonus;
    }

    public int getGrade() {
        return grade;
    }

    public int getCashPrize() {
        return cashPrize;
    }

    public static int getCashPrize(int grade) {
        for (Prize prize : values()) {
            if (prize.grade == grade) {
                return prize.cashPrize;
            }
        }
        throw new IllegalArgumentException(String.valueOf(grade));
    }

    public static Prize valueOf(int countOfMatch, boolean isMatchedBonus) {
        Prize[] prizes = values();
        return Arrays.stream(prizes)
            .filter(getPrizePredicate(countOfMatch, isMatchedBonus)).findAny()
            .orElse(NONE);
    }

    private static Predicate<Prize> getPrizePredicate(int countOfMatch, boolean isMatchedBonus) {
        return prize -> {
            if (prize.hitCount >= Prize.THIRD.hitCount) {
                return (prize.hitCount == countOfMatch) && (prize.isMatchedBonus == isMatchedBonus);
            }
            return prize.hitCount == countOfMatch;
        };
    }
}