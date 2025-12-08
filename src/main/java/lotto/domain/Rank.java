package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, new Money(2_000_000_000)),
    SECOND(5, new Money(30_000_000)),
    THIRD(5, new Money(1_500_000)),
    FOURTH(4, new Money(50_000)),
    FIFTH(3, new Money(5_000)),
    NO_MATCH(0, new Money(0));

    private int matchCount;
    private Money money;

    Rank(int matchCount, Money money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    public static Rank from(int matchCount, boolean hasBonusNumber) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.isSameMatchCount(matchCount))
                .filter(rank -> !rank.equals(SECOND) || hasBonusNumber) // 2등 확인 로직
                .findFirst()
                .orElse(NO_MATCH);
    }

    private boolean isSameMatchCount(int matchCount) {
        return this.matchCount == matchCount;
    }

    public Money addMoney(int money) {
        return addMoney(new Money(money));
    }

    public Money addMoney(Money money) {
        return this.money.add(money);
    }

    public Money totalPrize(int count) {
        return this.money.multiply(count);
    }
}
