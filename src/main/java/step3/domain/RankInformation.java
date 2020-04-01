package step3.domain;

import java.math.BigDecimal;
import java.util.Arrays;

public enum RankInformation {
    EQUALS_COUNT_3(1, 3, BigDecimal.valueOf(5000)),
    EQUALS_COUNT_4(2, 4, BigDecimal.valueOf(50000)),
    EQUALS_COUNT_5(3, 5, BigDecimal.valueOf(1500000)),
    EQUALS_COUNT_BONUS_5(4, 5, BigDecimal.valueOf(30000000), true),
    EQUALS_COUNT_6(5, 6, BigDecimal.valueOf(2000000000));

    private final int index;
    private final int count;
    private final BigDecimal price;
    private final boolean bonusballMatch;

    public int getCount() {
        return count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    RankInformation(int index, int count, BigDecimal price) {
        this(index, count, price, false);
    }

    RankInformation(int index, int count, BigDecimal price, boolean bonusballMatch) {
        this.index = index;
        this.count = count;
        this.price = price;
        this.bonusballMatch = bonusballMatch;
    }

    public static RankInformation matchWinInformation(int count, boolean bonusballMatch) {
        return Arrays.asList(values()).stream()
                .filter(d -> d.count == count)
                .filter(d -> d.bonusballMatch == bonusballMatch)
                .findFirst()
                .orElse(null);
    }

    public static RankInformation matchWinInformationByIndex(int index) {
        return Arrays.asList(values()).stream()
                .filter(d -> d.index == index)
                .findFirst()
                .orElse(null);
    }

    public static int matchWinInformationAllCount() {
        return (int) Arrays.asList(values()).stream()
                .count();
    }
}
