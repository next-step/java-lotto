package lotto.domain;

public enum Prize {
    SIX(6, 2_000_000_000),
    FIVE(5, 1_500_000),
    FOUR(4, 50000),
    THREE(3, 5000);

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
        for (Prize prize : Prize.values()) {
            if (prize.hit == hit) {
                return prize.getValue();
            }
        }
        return 0;
    }
}
