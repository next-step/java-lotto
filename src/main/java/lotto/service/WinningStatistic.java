package lotto.service;

import lotto.domain.PRIZE;

import java.util.Stack;

public class WinningStatistic {

    Stack<Integer> statistic = new Stack<>();
    static int money;


    public Stack<Integer> calculateStatistic(int prize) {
        money = prize;
        for (PRIZE price : PRIZE.values()) {
            int count = 0;
            putCount(price, count);
        }
        return statistic;
    }

    private void putCount(PRIZE price, int count) {
        while(money >= price.getValue()){
            money -= price.getValue();
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
