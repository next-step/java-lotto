package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum Prize {

    FIRST(6, 2_000_000_000, Constants.BONUS_IRRELEVANT),
    SECOND(5, 30_000_000, Constants.BONUS_HIT),
    THIRD(5, 1_500_000, Constants.BONUS_IRRELEVANT),
    FOURTH(4, 50000, Constants.BONUS_IRRELEVANT),
    FIFTH(3, 5000, Constants.BONUS_IRRELEVANT),
    MISS(0,0,Constants.BONUS_IRRELEVANT);

    private int hit;
    private int value;
    private List<Boolean> bonus;

    Prize(int hit, int value, List<Boolean> bonus) {
        this.hit = hit;
        this.value = value;
        this.bonus = bonus;
    }

    public static Prize getHit(int hit, boolean bonus) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.hit == hit && prize.bonus.contains(bonus))
                .findFirst()
                .orElse(Prize.MISS);
    }

    public int getValue() {
        return value;
    }

    private static class Constants {
        public static final List<Boolean> BONUS_HIT = List.of(true);
        public static final List<Boolean> BONUS_MISS = List.of(false);
        public static final List<Boolean> BONUS_IRRELEVANT = List.of(true,false);
    }
}
