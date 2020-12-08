package lottery.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class LotteryResult {
    private Map<LotteryValue, Integer> lotteryResultMap;
    private final LotteryWinning winningTicket;

    public LotteryResult(String winnerNumbers) {
        lotteryResultMap = new LinkedHashMap<LotteryValue, Integer>(){{
            put(LotteryValue.FORTH_PLACE, 0);
            put(LotteryValue.THIRD_PLACE, 0);
            put(LotteryValue.SECOND_PLACE, 0);
            put(LotteryValue.FIRST_PLACE, 0);
        }};
        winningTicket = new LotteryWinning(winnerNumbers);
    }

    public Map<LotteryValue, Integer> getLotteryResultMap() {
        return this.lotteryResultMap;
    }

    public BigDecimal getProfit(int purchaseAmount) {
        int profit = 0;
        for (LotteryValue key : lotteryResultMap.keySet()) {
            profit += (lotteryResultMap.get(key) * key.getAmount());
        }
        return new BigDecimal(profit).divide(new BigDecimal(purchaseAmount), 3, RoundingMode.HALF_EVEN);
    }

    public LotteryResult match(List<LotteryTicket> lotteryTickets) {
        for (LotteryTicket lotteryTicket : lotteryTickets) {
            this.addLotteryResult(this.winningTicket.getCountsMatched(lotteryTicket));
        }
        return this;
    }

    protected void addLotteryResult(int key) {
        LotteryValue resultKey = LotteryValue.findByAmount(key);
        if (resultKey.equals(LotteryValue.MISS)) {
            return;
        }
        this.lotteryResultMap.replace(resultKey, lotteryResultMap.get(resultKey) + 1);
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
