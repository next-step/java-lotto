package lotto.lotto;

import java.util.Arrays;
import java.util.Map;

public enum LottoMarginCalculator {
    RANK_ONE(6, (map) -> map.getOrDefault(6, 0) * WinningPrice.TWO_HUNDRED_MILLION.winPrice),
    RANK_TWO(5, (map) -> map.getOrDefault(5, 0) * WinningPrice.ONE_MILLION_FIVE_HUNDRED.winPrice),
    RANK_THREE(4, (map) -> map.getOrDefault(4, 0) * WinningPrice.FIFTY_THOUSAND.winPrice),
    RANK_FOUR(3, (map) -> map.getOrDefault(3, 0) * WinningPrice.FIVE_THOUSAND.winPrice);

    private final int machingCnt;
    private final MarginOperation marginOperation;

    LottoMarginCalculator(final int machingCnt, MarginOperation marginOperation) {
        this.machingCnt = machingCnt;
        this.marginOperation = marginOperation;
    }

    public static double calculateMarginRate(long price, Map<Integer, Integer> resultMap) {
        return Arrays.stream(LottoMarginCalculator.values()).mapToLong(value -> value.marginOperation.multiply(resultMap)).sum() / (double) price;
    }


}
