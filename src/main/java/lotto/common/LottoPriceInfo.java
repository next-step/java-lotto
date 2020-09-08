package lotto.common;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum LottoPriceInfo {
    LOTTO_RANK_4(3, 5_000),
    LOTTO_RANK_3(4, 50_000),
    LOTTO_RANK_2(5, 1_500_000),
    LOTTO_RANK_1(6, 2_000_000_000),

    LOTTO_RANK_0(0, 0);

    private static final Map<Integer, LottoPriceInfo> lottoPriceInfoMap;

    static {
        lottoPriceInfoMap = Arrays.stream(LottoPriceInfo.values())
                .filter(priceInfo -> priceInfo.price > 0)
                .collect(Collectors.toMap(LottoPriceInfo::getMatchCount, lottoPriceInfo -> lottoPriceInfo));
    }

    private int matchCount;
    private int price;

    LottoPriceInfo(Integer matchCount, Integer price) {
        this.matchCount = matchCount;
        this.price = price;
    }

    public static int calculateTotalPrice(Map<Integer, Integer> matchResult) {
        return Arrays.stream(LottoPriceInfo.values())
                .mapToInt(lottoPriceInfo
                        -> matchResult.getOrDefault(lottoPriceInfo.matchCount, 0)
                        * lottoPriceInfo.price)
                .sum();
    }

    public int calculatePrice(int matchTicketCount) {
        return this.price * matchTicketCount;
    }

    public long calculatePrice(long matchTicketCount) {
        return this.price * matchTicketCount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrice() {
        return price;
    }

    public static LottoPriceInfo matchInfo(int matchCount) {
        if (!lottoPriceInfoMap.containsKey(matchCount)) {
            return LottoPriceInfo.LOTTO_RANK_0;
        }

        return lottoPriceInfoMap.get(matchCount);
    }
}
