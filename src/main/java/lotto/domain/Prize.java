package lotto.domain;

import java.util.Arrays;

public enum Prize {
    FOURTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1500000),
    FIRST(6, 2000000000);

    private int matchCount;
    private int money;

    Prize(int matchCount, int money) {
        this.matchCount = matchCount;
        this.money = money;

    }

    public boolean isSameMatchCount(int matchCount) {

        return this.matchCount == matchCount;
    }

    public int getMoney() {
        return money;
    }

    public static Prize findByMoney(int matchCount) {
        return Arrays.stream(values())
                .filter(prize -> prize.isSameMatchCount(matchCount))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }


}
