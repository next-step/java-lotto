package lotto.domain;

import java.util.Arrays;

public enum LottoPrize {
    FirstPrizeMoney(1, 6, 2000000000),
    SecondPrizeMoney(2, 5, 1500000),
    ThirdPrizeMoney(3, 4, 50000),
    ForthPrizeMoney(4, 3, 5000),
    FifthPrizeMoney(5, 2, 0),
    SixthPrizeMoney(6, 1, 0),
    SeventhPrizeMoney(7, 0, 0),
    ;

    private final int prize;
    private final int matchCount;
    private final int money;

    LottoPrize(int prize, int matchCount, int money) {
        this.prize = prize;
        this.matchCount = matchCount;
        this.money = money;
    }

    public int getPrize() {
        return prize;
    }

    public int getMoney() {
        return money;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public static LottoPrize valueOf(int matchCount) {
        return Arrays.stream(values())
                .filter(v -> (matchCount == v.matchCount))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
