package lotto.domain;

import java.util.Arrays;
import java.util.Optional;

public enum WinnerType {

    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000);

    private final int sameCount;
    private final int prize;

    WinnerType(int sameCount, int prize) {
        this.sameCount = sameCount;
        this.prize = prize;
    }

    public static Optional<WinnerType> findByCount(int count) {
        return Arrays.stream(WinnerType.values())
                .filter(o -> o.getSameCount() == count)
                .findFirst();
    }

    public int getSameCount() {
        return sameCount;
    }

    public int getPrize() {
        return prize;
    }

    public int calculatePrize(Integer number) {
        return prize * number;
    }
}
