package lottery.domain;

import java.util.*;

public class LotteryResult {
    public static final int LIMIT_MATCHED_NUMBER = 3;
    Map<Integer, Integer> lotteryResultMap;
    private final Map<Integer, Integer> lotteryValueMap;

    public LotteryResult() {
        lotteryResultMap = new HashMap<>();
        lotteryValueMap = new HashMap<Integer, Integer>() {
            {
                put(3, 5000);
                put(4, 50000);
                put(5, 1500000);
                put(6, 2000000000);
            }
        };
    }

    public LotteryResult(int key, int value) {
        this();
        this.lotteryResultMap.put(key, value);
    }

    public void update(int key, int value) {
        if (key < LIMIT_MATCHED_NUMBER) return;
        if (this.lotteryResultMap.containsKey(key)) {
            this.lotteryResultMap.replace(key, lotteryResultMap.get(key) + value);
        }
        if (!this.lotteryResultMap.containsKey(key)) {
            this.lotteryResultMap.put(key, value);
        }
    }

    public double getProfit(int purchaseAmount) {
        int profit = 0;
        for (Integer key : lotteryResultMap.keySet()) {
            profit += (lotteryResultMap.get(key) * lotteryValueMap.get(key));
        }
        return profit / (double) purchaseAmount;
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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("당첨 통계");
        stringBuilder.append(System.getProperty("line.separator"));
        stringBuilder.append("---------");
        stringBuilder.append(System.getProperty( "line.separator"));

        for (Integer key : lotteryResultMap.keySet()) {
            stringBuilder.append(key);
            stringBuilder.append("개 일치 (");
            stringBuilder.append(")- ");
            stringBuilder.append(lotteryResultMap.get(key));
            stringBuilder.append("개");
            stringBuilder.append(System.getProperty("line.separator"));
        }
        return stringBuilder.toString();
    }
}
