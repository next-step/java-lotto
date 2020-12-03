package lottery.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class LotteryResult {
    public static final int LIMIT_MATCHED_NUMBER = 3;
    Map<Integer, Integer> lotteryResultMap;
    private final LotteryTicket winnerTicket;

    public LotteryResult(String winnerNumbers) {
        lotteryResultMap = new HashMap<>();
        winnerTicket = new LotteryTicket(winnerNumbers);
    }

    public LotteryResult(String winnerNumbers, int key, int value) {
        this(winnerNumbers);
        this.lotteryResultMap.put(key, value);
    }

    public void addLotteryResult(int key, int value) {
        if (key < LIMIT_MATCHED_NUMBER) {
            return;
        }
        if (this.lotteryResultMap.containsKey(key)) {
            this.lotteryResultMap.replace(key, lotteryResultMap.get(key) + value);
        }
        this.lotteryResultMap.put(key, value);
    }

    public BigDecimal getProfit(int purchaseAmount) {
        int profit = 0;
        for (Integer key : lotteryResultMap.keySet()) {
            profit += (lotteryResultMap.get(key) * LotteryValue.findByAmount(key).getAmount());
        }
        return new BigDecimal(profit).divide(new BigDecimal(purchaseAmount), 3, RoundingMode.HALF_EVEN);
    }

    public LotteryResult match(List<LotteryTicket> lotteryTickets) {
        for (LotteryTicket lotteryTicket : lotteryTickets) {
            this.addLotteryResult(lotteryTicket.getCountsMatched(this.winnerTicket), 1);
        }
        return this;
    }

    public Map<Integer, Integer> getLotteryResultMap() {
        return this.lotteryResultMap;
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
