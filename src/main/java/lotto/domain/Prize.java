package lotto.domain;

import java.util.Arrays;

public enum Prize {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    MISS(0, 0);

    private int hit;
    private int value;

    Prize(int hit, int value) {
        this.hit = hit;
        this.value = value;
    }

    public static Prize getHit(int hit, boolean bonus) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.hit == hit)
                .map(prize -> checkHitFive(prize, hit, bonus))
                .findFirst()
                .orElse(Prize.MISS);
    }

    private static Prize checkHitFive(Prize prize, int hit, boolean bonus) {
        if (hit == Prize.SECOND.hit || hit == Prize.THIRD.hit) {
            return checkHitBonus(bonus);
        }
        return prize;
    }

    private static Prize checkHitBonus(boolean bonus) {
        if (bonus) {
            return Prize.SECOND;
        }
        return Prize.THIRD;
    }

    public int getValue() {
        return value;
    }

}
