package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class Statistics {

    Map<String, Integer> rank;
    long totalEarnMoney;
    double earnMoneyPercentage;

    public Statistics() {
        rank = new HashMap<>();
        rank.put(WinningLotto.FIRST, 0);
        rank.put(WinningLotto.SECOND, 0);
        rank.put(WinningLotto.THIRD, 0);
        rank.put(WinningLotto.FOURTH, 0);
        rank.put(WinningLotto.FIFTH, 0);
        rank.put(WinningLotto.MISS, 0);
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
