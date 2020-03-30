package step2.domain;

import java.math.BigDecimal;
import java.util.Arrays;

public enum WinInformation {
    EQUALS_COUNT_3(3, BigDecimal.valueOf(5000)),
    EQUALS_COUNT_4(4, BigDecimal.valueOf(50000)),
    EQUALS_COUNT_5(5, BigDecimal.valueOf(1500000)),
    EQUALS_COUNT_6(6, BigDecimal.valueOf(2000000000));

    private final int count;
    private final BigDecimal price;

    public int getCount() {
        return count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    WinInformation(int count, BigDecimal price) {
        this.count = count;
        this.price = price;
    }

    public static WinInformation matchWinInformation(int count) {
        return Arrays.asList(values()).stream().filter(d -> d.count == count).findFirst().orElse(null);
    }
}
