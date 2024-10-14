package lotto.service;

import lotto.domain.Prize;

import java.util.Stack;

public class WinningStatistic {

    private final Stack<Integer> statistic;
    private int totalPrize;

    public WinningStatistic(int totalPrize, Stack<Integer> statistic) {
        this.statistic = statistic;
        this.totalPrize = totalPrize;
    }


    public Stack<Integer> calculateStatistic() {
        for (Prize price : Prize.values()) {
            int count = 0;
            putCount(price, count);
        }
        return statistic;
    }

    private void putCount(Prize price, int count) {
        while(totalPrize >= price.getValue()){
            totalPrize -= price.getValue();
            count +=1;
        }
        statistic.add(count);
    }
    public Stack<Integer> getStatistic() {
        return statistic;
    }

    public double calculateProfit(int prize, int buyPrice) {
        return Math.floor(prize / (double) buyPrice *100) / 100.0 ;
    }
}
