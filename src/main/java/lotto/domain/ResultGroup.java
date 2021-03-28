package lotto.domain;

import java.util.HashMap;

public class ResultGroup {

    private static HashMap<ResultMap, Integer> result;

    static {
        result = new HashMap<>();
        for (ResultMap resultMap : ResultMap.values()) {
            result.put(resultMap, 0);
        }
    }

    public void update(ResultMap resultMap) {
        result.put(resultMap, result.get(resultMap) + 1);
    }

    public String showResult() {
        StringBuilder resultBuilder = new StringBuilder();
        for (ResultMap resultMap : ResultMap.winningResults()) {
            resultBuilder.append(String.format("%s - %d개", resultMap.showResult(), result.get(resultMap))).append("\n");
        }
        return resultBuilder.toString();
    }

    public double getRates(Money money) {
        double profit = getProfit();
        return calculateRates(profit, money.value());
    }

    private double calculateRates(double profit, int value) {
        return (profit / value);
    }

    private double getProfit() {
        double profit = 0;
        for (ResultMap resultMap : ResultMap.winningResults()) {
            profit += resultMap.prize() * result.get(resultMap);
        }
        return profit;
    }
}
