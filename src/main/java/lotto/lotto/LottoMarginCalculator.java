package lotto.lotto;

import java.util.Arrays;
import java.util.Map;

public enum LottoMarginCalculator {

    RANK_ONE(6, WinningPrice.TWO_HUNDRED_MILLION.winPrice),
    RANK_TWO(5, WinningPrice.ONE_MILLION_FIVE_HUNDRED.winPrice),
    RANK_TWO_BONUS(5, WinningPrice.THIRTY_MILLION.winPrice),
    RANK_THREE(4, WinningPrice.FIFTY_THOUSAND.winPrice),
    RANK_FOUR(3, WinningPrice.FIVE_THOUSAND.winPrice);

    private final int machingCnt;
    private final long winPrice;

    LottoMarginCalculator(final int machingCnt, final long winPrice) {
        this.machingCnt = machingCnt;
        this.winPrice = winPrice;
    }

    public static double calculateMarginRate(long price, Map<LottoMarginCalculator, Integer> resultMap) {
        return Arrays.stream(LottoMarginCalculator.values()).mapToLong(value -> value.winPrice * resultMap.getOrDefault(value,0)).sum() / (double) price;
    }

    public int getMachingCnt() {
        return machingCnt;
    }

    public long getWinPrice() {
        return winPrice;
    }
}
