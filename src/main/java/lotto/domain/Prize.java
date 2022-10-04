package lotto.domain;

public enum Prize {
    FIRST(6, new Money(2000000000)), 
    SECOND(5, new Money(1500000)), 
    THIRD(4, new Money(50000)), 
    FOURTH(3, new Money(5000)), 
    NO_PRIZE(0, new Money(0));

    private final int matchCount;
    private final Money money;

    Prize(int matchCount, Money money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    public static Prize get(int matchCount) {
        if (matchCount == FIRST.matchCount) {
            return FIRST;
        }
        if (matchCount == SECOND.matchCount) {
            return SECOND;
        }
        if (matchCount == THIRD.matchCount) {
            return THIRD;
        }
        if (matchCount == FOURTH.matchCount) {
            return FOURTH;
        }
        return NO_PRIZE;
    }

    public long value() {
        return money.value();
    }
}
