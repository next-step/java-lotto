package lottery_auto.strategy;

import java.util.EnumMap;
import java.util.Map;
import lottery_auto.type.WinningMatch;


public class ProfitRateStrategyImpl implements ProfitRateStrategy{

    private static final int MIN_NUMBER = 0;
    private static final int INT_HUNDRED = 100;
    private static final double DOUBLE_HUNDRED = 100.0;

    @Override
    public int calculate(EnumMap<WinningMatch, Integer> matchList) {
        return matchList.entrySet().stream()
                .filter(match -> match.getValue() > MIN_NUMBER)
                .map(Map.Entry::getKey)
                .map(WinningMatch::getWinnings)
                .reduce(MIN_NUMBER, Integer::sum);
    }

    @Override
    public double calculateRate(double rate) {
        return Math.floor(rate * INT_HUNDRED) / DOUBLE_HUNDRED;
    }
}
