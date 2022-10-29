package lotto.domain;

import java.util.Arrays;

public enum Prize {
    FIRST(new Money(2_000_000_000), 6, false), 
    SECOND(new Money(30_000_000), 5, true), 
    THIRD(new Money(1_500_000), 5, false), 
    FOURTH(new Money(50_000), 4, false), 
    FIFTH(new Money(5_000), 3, false), 
    NO_PRIZE(new Money(0), 0, false);
    
    private final Money money;
    private final int countOfMatch;
    private final boolean needBonusNumber;

    Prize(Money money, int countOfMatch, boolean needBonusNumber) {
        this.money = money;
        this.countOfMatch = countOfMatch;
        this.needBonusNumber = needBonusNumber;
    }

    public static Prize valueOf(MatchingCount count) {
        return Arrays.stream(values()).filter(prize -> match(prize, count))
                     .findFirst()
                     .orElse(NO_PRIZE);
    }

    private static boolean match(Prize prize, MatchingCount count) {
        return count.is(prize.countOfMatch, prize.needBonusNumber);
    }
    
    public int getMatchCount() {
        return countOfMatch;
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

    public boolean needBonusNumber() {
        return needBonusNumber;
    }
}
