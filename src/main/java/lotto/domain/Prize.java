package lotto.domain;

import java.util.Arrays;

public enum Prize {

    FIRST(6, 2_000_000_000, Constants.BONUS_MISS),
    SECOND(5, 30_000_000, Constants.BONUS_HIT),
    THIRD(5, 1_500_000, Constants.BONUS_MISS),
    FOURTH(4, 50000, Constants.BONUS_MISS),
    FIFTH(3, 5000, Constants.BONUS_MISS),
    MISS(0,0,Constants.BONUS_MISS);

    private int hit;
    private int value;
    private boolean bonus;

    Prize(int hit, int value, boolean bonus) {
        this.hit = hit;
        this.value = value;
        this.bonus = bonus;
    }

    public static Prize getHit(int hit, boolean bonus) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.hit == hit && prize.bonus == bonus)
                .findFirst()
                .orElse(Prize.MISS);
    }

    public int getValue() {
        return value;
    }

    private static class Constants {
        public static final boolean BONUS_HIT = true;
        public static final boolean BONUS_MISS = false;
    }
}
