package lotto.common;

import java.util.Arrays;
import java.util.Map;
import lotto.domain.LottoMatchResult;

public enum LottoPriceInfo {
    LOTTO_RANK_4(3, 5_000),
    LOTTO_RANK_3(4, 50_000),
    LOTTO_RANK_2(5, 1_500_000),
    LOTTO_RANK_1(6, 2_000_000_000);

    private Integer matchCount;
    private Integer price;

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

    public int matchTicketCount(LottoMatchResult lottoMatchResult) {
        return lottoMatchResult.getMatchTicketCount(this.matchCount);
    }

    public Integer getMatchCount() {
        return matchCount;
    }

    public Integer getPrice() {
        return price;
    }
}
