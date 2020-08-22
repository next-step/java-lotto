package lotto;

import java.util.Arrays;
import java.util.Map;

public enum LottoPriceInfo {
    MATCH_COUNT_6(6, 2_000_000_000),
    MATCH_COUNT_5(5, 1_500_000),
    MATCH_COUNT_4(4, 50_000),
    MATCH_COUNT_3(3, 5_000);

    private Integer matchCount;
    private Integer price;

    LottoPriceInfo(Integer matchCount, Integer price) {
        this.matchCount = matchCount;
        this.price = price;
    }

    public static int calculateTotalPrice(Map<Integer, Integer> matchResult) {
        return Arrays.stream(LottoPriceInfo.values())
                .mapToInt(lottoPriceInfo
                        -> matchResult.getOrDefault(lottoPriceInfo.matchCount, 0) * lottoPriceInfo.price)
                .sum();
    }

    public int calculatePrice(int matchTicketCount) {
        return this.price * matchTicketCount;
    }
}
