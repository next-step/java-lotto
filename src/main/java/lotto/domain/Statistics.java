package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class Statistics {

    private Map<String, Integer> rank;
    private long totalEarnMoney;
    private double earnMoneyPercentage;

    public Statistics() {
        rank = new HashMap<>();
        rank.put(WinnigResult.FIRST, 0);
        rank.put(WinnigResult.SECOND, 0);
        rank.put(WinnigResult.THIRD, 0);
        rank.put(WinnigResult.FOURTH, 0);
        rank.put(WinnigResult.FIFTH, 0);
        rank.put(WinnigResult.MISS, 0);
        totalEarnMoney = 0;
    }

    public void calculateRank(String status, long earnMoney) {
        rank.put(status, rank.getOrDefault(status,0) + 1);
        totalEarnMoney += earnMoney;
    }

    public int winningCount(String status) {
        return rank.getOrDefault(status, 0);
    }

    public double getEarnMoneyPercentage() {
        return earnMoneyPercentage;
    }

    public void setEarnMoneyPercentage(int buyLottoMoney) {
        earnMoneyPercentage = (double) totalEarnMoney / buyLottoMoney;
    }

}
