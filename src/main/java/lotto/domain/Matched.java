package lotto.domain;

import java.util.Arrays;

public enum Matched {
    ALL(0, 6, false, 2000000000),
    FIVE_AND_BONUS(1, 5, true, 30000000),
    FIVE(2, 5, false, 1500000),
    FOUR(3, 4, false, 50000),
    THREE(4, 3, false, 5000),
    TWO(5, 2, false, 0),
    ONE(6, 1, false, 0),
    NONE(7, 0, false, 0);

    Matched(int index, int numberOfMatched, boolean isMatchedBonus, int reward) {
        this.index = index;
        this.numberOfMatched = numberOfMatched;
        this.isMatchedBonus = isMatchedBonus;
        this.reward = reward;
    }

    private final int index;

    private final int numberOfMatched;

    private final boolean isMatchedBonus;

    private final int reward;

    public int index() {
        return index;
    }

    public int numberOfMatched() {
        return numberOfMatched;
    }

    public int reward() {
        return reward;
    }

    public static Matched valueOf(int numberOfMatched, boolean isMatchedBonus) {
        Matched[] matcheds = values();

        return Arrays
                .stream(matcheds)
                .filter(matched -> isMatched(numberOfMatched, isMatchedBonus, matched))
                .findFirst()
                .orElse(Matched.NONE);
    }

    private static boolean isMatched(int numberOfMatched, boolean isMatchedBonus, Matched matched) {
        return matched.numberOfMatched == numberOfMatched && matched.isMatchedBonus == isMatchedBonus;
    }
}
