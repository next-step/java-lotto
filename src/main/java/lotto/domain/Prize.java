package lotto.domain;

import static lotto.domain.BonusCondition.ANY;
import static lotto.domain.BonusCondition.MUST_MATCH;
import static lotto.domain.BonusCondition.MUST_NOT_MATCH;

import java.util.Arrays;

public enum Prize {

    NONE(0, ANY, 0),
    FIFTH_PLACE(3, ANY, 5_000),
    FOURTH_PLACE(4, ANY, 50_000),
    THIRD_PLACE(5, MUST_NOT_MATCH, 1_500_000),
    SECOND_PLACE(5, MUST_MATCH, 30_000_000),
    FIRST_PLACE(6, ANY, 2_000_000_000),
    ;

    private final int matchingCount;
    private final BonusCondition bonusCondition;
    private final int amount;

    Prize(int matchingCount, BonusCondition bonusCondition, int amount) {
        this.matchingCount = matchingCount;
        this.bonusCondition = bonusCondition;
        this.amount = amount;
    }

    public static Prize from(int matchingCount, boolean matchedBonus) {
        return Arrays.stream(values())
            .filter(p -> p.matchingCount == matchingCount)
            .filter(p -> p.bonusCondition.match(matchedBonus))
            .findAny()
            .orElse(Prize.NONE);
    }

    public static Prize[] valuesWithoutNone() {
        return Arrays.stream(values()).filter(prize -> prize != Prize.NONE).toArray(Prize[]::new);
    }

    public int amount() {
        return amount;
    }

    public int matchingCount() {
        return matchingCount;
    }
}
