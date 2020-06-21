package step2.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
    private long cashPrize;
    private int hitCount;
    private boolean isMatchedBonus;

    Prize(int grade, long cashPrize, int hitCount, boolean isMatchedBonus) {
        this.grade = grade;
        this.cashPrize = cashPrize;
        this.hitCount = hitCount;
        this.isMatchedBonus = isMatchedBonus;
    }

    public int getGrade() {
        return grade;
    }

    public long getCashPrize() {
        return cashPrize;
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

    public static Prize[] winningValues() {
        List<Prize> prizes = new ArrayList<>();
        prizes.addAll(Arrays.asList(values()));
        prizes.removeIf(prize -> prize == NONE);
        Collections.sort(prizes, (prize1, prize2) -> prize2.getGrade() - prize1.getGrade());
        return prizes.toArray(new Prize[prizes.size()]);
    }

    @Override
    public String toString() {
        return "Prize{" +
            "grade=" + grade +
            ", cashPrize=" + cashPrize +
            ", hitCount=" + hitCount +
            ", isMatchedBonus=" + isMatchedBonus +
            '}';
    }
}