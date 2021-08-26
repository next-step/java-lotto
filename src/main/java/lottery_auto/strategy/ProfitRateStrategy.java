package lottery_auto.strategy;

import java.util.EnumMap;
import lottery_auto.type.WinningMatch;

import java.util.List;

public interface ProfitRateStrategy {
    int calculate(EnumMap<WinningMatch, Integer> matchList);
    double calculateRate(double rate);
}
