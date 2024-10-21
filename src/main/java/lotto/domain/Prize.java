package lotto.domain;

import java.util.Arrays;

public enum Prize {

    FIRST(6, 2_000_000_000, Constants.BONUS_MISS),
    SECOND(5,30_000_000, Constants.BONUS_HIT),
    THIRD(5, 1_500_000, Constants.BONUS_MISS),
    FOURTH(4, 50000, Constants.BONUS_MISS),
    FIFTH(3, 5000, Constants.BONUS_MISS);

    private int hit;
    private int value;
    private boolean bonus;

    Prize(int hit, int value, boolean bonus) {
        this.hit = hit;
        this.value = value;
        this.bonus = bonus;
    }

    public int getValue() {
        return value;
    }

    public static int getValueByHit(int hit, boolean bonus) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.hit == hit && prize.bonus == bonus)
                .map(Prize::getValue)
                .findFirst()
                .orElse(0);
    }

    private static class Constants {
        public static final boolean BONUS_HIT = true;
        public static final boolean BONUS_MISS = false;
    }
}
