package step2.domain;

import java.util.Arrays;

public enum LottoMatchingCount {
    TREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000),
    DEFAULT(0, 0);

    private final int count;
    private final int money;

    LottoMatchingCount(int count, int money) {
        this.count = count;
        this.money = money;
    }

    public int getCount() {
        return count;
    }

    public int getMoney() {
        return money;
    }

    public static LottoMatchingCount toLottoMatchingCount(int count) {
        return Arrays.stream(LottoMatchingCount.values())
                .filter(enumList -> enumList.getCount() == count)
                .findFirst()
                .orElse(LottoMatchingCount.DEFAULT);
    }
}
