package lotto.type;

import java.util.Arrays;

public enum Winning {

    FOURTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1500000),
    FIRST(6, 2000000000);

    private final int count;
    private final long reward;

    Winning(int count, long reward) {
        this.count = count;
        this.reward = reward;
    }

    public static Winning findByWinning(int count) {
        return Arrays.stream(Winning.values())
                .filter(winning -> winning.count == count)
                .findAny().orElseThrow(() -> new IllegalArgumentException());
    }


    public long getReward() {
        return this.reward;
    }

    public int getCount() {
        return this.count;
    }


}
