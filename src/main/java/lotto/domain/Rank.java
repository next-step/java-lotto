package lotto.domain;

public enum Rank {
    NO_RANK(0, Money.from(0)),
    FOURTH_RANK(3, Money.from(5000)),
    THIRD_RANK(4, Money.from(50000)),
    SECOND_RANK(5, Money.from(1500000)),
    FIRST_RANK(6, Money.from(2000000000));

    private final int matchCount;
    private final Money money;

    Rank(int matchCount, Money money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public Money getMoney() {
        return money;
    }
}
