package lotto.domain;

import java.util.Arrays;

public enum Prize {

    FIRST(6, 2_000_000_000),
    SECOND(5,30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

    private int hit;
    private int value;

    Prize(int hit, int value) {
        this.hit = hit;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static int getValueByHit(int hit) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.hit == hit)
                .map(Prize::getValue)
                .findFirst()
                .orElse(0);
    }

    public static int getSecondPrizeOrThirdPrize(boolean bonusNumber) {
        if(bonusNumber) {
            return SECOND.getValue();
        }
        return THIRD.getValue();
    }

}
