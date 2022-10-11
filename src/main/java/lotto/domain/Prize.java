package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Prize {
    FIRST(6, new Money(2_000_000_000)), 
    SECOND(5, new Money(1_500_000)), 
    THIRD(4, new Money(50_000)), 
    FOURTH(3, new Money(5_000)), 
    NO_PRIZE(0, new Money(0));

    private final int matchCount;
    private final Money money;

    Prize(int matchCount, Money money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    public int getMatchCount() {
        return matchCount;
    }
    
    public long value() {
        return money.value();
    }
    
    public static Prize get(int matchCount) {
        return Arrays.stream(values()).filter(prize -> prize.matchCount == matchCount)
                                      .findFirst()
                                      .orElse(NO_PRIZE);
    }
    
    public static List<Prize> getAll() {
        return Arrays.stream(values()).filter(prize -> prize != NO_PRIZE).collect(Collectors.toList());
    }
}
