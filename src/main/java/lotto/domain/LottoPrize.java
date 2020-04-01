package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum LottoPrize {
    FIRST(6, 2_000_000_000, "6개 일치 (2000000000원)"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30000000원)"),
    THIRD(5, 1_500_000, "5개 일치 (1500000원)"),
    FOURTH(4, 50_000, "4개 일치 (50000원)"),
    FIFTH(3, 5_000, "3개 일치 (5000원)"),
    NONE(0, 0, "");

    public static final List<LottoPrize> PRIZES = Arrays.asList(FIFTH, FOURTH, THIRD, SECOND, FIRST);

    private int matchCount;
    private int price;
    private String message;

    LottoPrize(int matchCount, int price, String message) {
        this.matchCount = matchCount;
        this.price = price;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrice() {
        return price;
    }

    public static LottoPrize find(int count, boolean isMatchBonus) {
        return Arrays.stream(LottoPrize.values())
                .filter(prize -> prize.matchCount == count)
                .filter(prize -> !prize.equals(SECOND) || isMatchBonus)
                .findFirst()
                .orElse(LottoPrize.NONE);
    }
}
