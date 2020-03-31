package step3.domain;

import com.sun.org.apache.xpath.internal.functions.FuncFalse;

import java.math.BigDecimal;
import java.util.Arrays;

public enum WinInformation {
    EQUALS_COUNT_3(1,3, BigDecimal.valueOf(5000), "개 일치"),
    EQUALS_COUNT_4(2,4, BigDecimal.valueOf(50000), "개 일치"),
    EQUALS_COUNT_5(3,5, BigDecimal.valueOf(1500000), "개 일치"),
    EQUALS_COUNT_BONUS_5(4, 5, BigDecimal.valueOf(30000000),"개 일치, 보너스 볼 일치", true),
    EQUALS_COUNT_6(5, 6, BigDecimal.valueOf(2000000000), "개 일치");

    private final int index;
    private final int count;
    private final BigDecimal price;

    public boolean isBonusballMatch() {
        return bonusballMatch;
    }

    private final boolean bonusballMatch;
    private final String title;

    public int getCount() {
        return count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    WinInformation(int index, int count, BigDecimal price, String title) {
        this(index, count, price, title, false);
    }
    WinInformation(int index, int count, BigDecimal price, String title,boolean bonusballMatch) {
        this.index = index;
        this.count = count;
        this.price = price;
        this.bonusballMatch = bonusballMatch;
        this.title = title;
    }

    public static int matchWinInformationAllCount() {
        return (int)Arrays.asList(values()).stream()
                .count();
    }

    public static int matchWinInformationCount(int count) {
        return (int)Arrays.asList(values()).stream()
                .filter(d -> d.count == count)
                .count();
    }

    public static WinInformation matchWinInformation(int count, boolean bonusballMatch) {
        return Arrays.asList(values()).stream()
        .filter(d -> d.count == count)
        .filter(d -> d.bonusballMatch == bonusballMatch)
        .findFirst()
        .orElse(null);
    }

    public static WinInformation matchWinInformationByIndex(int index) {
        return Arrays.asList(values()).stream()
        .filter(d -> d.index == index)
        .findFirst()
        .orElse(null);
    }
}
