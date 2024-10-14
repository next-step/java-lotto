package lotto.domain;

import lotto.constant.Prize;

import java.util.Arrays;
import java.util.EnumMap;

public class MissionProfitRateStrategy extends ProfitRateStrategy{

    @Override
    public String calculateProfitRate(EnumMap<Prize, Integer> countMap, CashAmount cashAmount) {
        int sum = Arrays.stream(Prize.values())
                .mapToInt(p -> p.getPrizeMoney() * countMap.getOrDefault(p, 0))
                .sum();
        double profitRate = cashAmount.calculateProfitRate(sum);
        return String.format("%.2f", profitRate);
    }

}
