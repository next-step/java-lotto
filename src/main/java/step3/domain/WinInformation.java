package step3.domain;

import java.math.BigDecimal;
import java.util.Arrays;

public enum WinInformation {
    EQUALS_COUNT_3(3, BigDecimal.valueOf(5000),0),
    EQUALS_COUNT_4(4, BigDecimal.valueOf(50000),0),
    EQUALS_COUNT_5(5, BigDecimal.valueOf(1500000),0),
    EQUALS_COUNT_BONUS_5(5, BigDecimal.valueOf(30000000),1),
    EQUALS_COUNT_6(6, BigDecimal.valueOf(2000000000),0);

    private final int count;
    private final BigDecimal price;
    private final int bonusCount;

    public int getCount() {
        return count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    WinInformation(int count, BigDecimal price, int bonusCount) {
        this.count = count;
        this.price = price;
        this.bonusCount = bonusCount;
    }

    public static WinInformation matchWinInformation(int count, int bonusCount) {
        return Arrays.asList(values()).stream()
        .filter(d -> (d.count == count && d.bonusCount == bonusCount))
        .findFirst()
        .orElse(null);
    }
}
