package lotto.type;

import java.util.Arrays;

public enum Winning {

    FIFTH(3, false, 5000),
    FOURTH(4, false, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000),
    FIRST(6, false, 2000000000);

    private final int count;
    private final boolean bonus;
    private final long reward;


    Winning(int count, boolean bonus, long reward) {
        this.count = count;
        this.bonus = bonus;
        this.reward = reward;
    }

    public static Winning findByWinning(int count, boolean bonus) {
        return Arrays.stream(Winning.values())
                .filter(winning -> winning.count == count)
                .filter(winning -> winning.bonus == bonus)
                .findAny().orElseThrow(() -> new IllegalArgumentException());
    }

    public long getReward() {
        return this.reward;
    }

    public int getCount() {
        return this.count;
    }

    public boolean isBonus() {
        return this.bonus;
    }
}
