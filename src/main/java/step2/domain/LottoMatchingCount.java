package step2.domain;

import java.util.Arrays;

public enum LottoMatchingCount {
    TREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000),
    DEFAULT(0, 0);

    private  final int count;
    private final int money;

    LottoMatchingCount(int count, int money) {
        this.count = count;
        this.money= money;
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
