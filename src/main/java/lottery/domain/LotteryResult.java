package lottery.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class LotteryResult {
    private Map<LotteryValue, Integer> lotteryResultMap;

    public LotteryResult() {
        lotteryResultMap = new LinkedHashMap<LotteryValue, Integer>(){{
            put(LotteryValue.FIFTH_PLACE, 0);
            put(LotteryValue.FORTH_PLACE, 0);
            put(LotteryValue.THIRD_PLACE, 0);
            put(LotteryValue.SECOND_PLACE, 0);
            put(LotteryValue.FIRST_PLACE, 0);
        }};
    }

    public Map<LotteryValue, Integer> getLotteryResultMap() {
        return this.lotteryResultMap;
    }

    public BigDecimal calculateProfit(LotteryAmount purchaseAmount) {
        int profit = 0;
        for (LotteryValue key : lotteryResultMap.keySet()) {
            profit += (lotteryResultMap.get(key) * key.getAmount());
        }
        return new BigDecimal(profit).divide(new BigDecimal(purchaseAmount.getAmount()), 3, RoundingMode.HALF_EVEN);
    }

    protected void updateLotteryResult(int key, boolean isMatchedBonusNumber) {
        LotteryValue place = LotteryValue.confirmPlace(key, isMatchedBonusNumber);
        if (LotteryValue.isNoPlace(place)) {
            return;
        }
        this.lotteryResultMap.replace(place, lotteryResultMap.get(place) + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotteryResult that = (LotteryResult) o;
        return Objects.equals(lotteryResultMap, that.lotteryResultMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotteryResultMap);
    }
}
