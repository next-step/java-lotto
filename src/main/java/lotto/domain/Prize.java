package lotto.domain;

import java.util.Arrays;

public enum Prize {
    FIRST(new Money(2_000_000_000), new MatchingCount(6)), 
    SECOND(new Money(30_000_000), new MatchingCount(5, true)), 
    THIRD(new Money(1_500_000), new MatchingCount(5)), 
    FOURTH(new Money(50_000), new MatchingCount(4)), 
    FIFTH(new Money(5_000), new MatchingCount(3)), 
    NO_PRIZE(new Money(0), new MatchingCount(0));

    private final Money money;
    private final MatchingCount count;

    Prize(Money money, MatchingCount count) {
        this.money = money;
        this.count = count;
    }

    public static Prize valueOf(MatchingCount count) {
        return Arrays.stream(values()).filter(prize -> prize.count.equals(count))
                     .findFirst()
                     .orElse(NO_PRIZE);
    }

    public int getMatchCount() {
        return count.getCountOfMatch();
    }

    public Money getMoney() {
        return money;
    }

    public long value() {
        return money.value();
    }
    
    public boolean exist() {
        return this != NO_PRIZE;
    }

    public boolean hasBonusNumber() {
        return count.hasBonusNumber();
    }
}
