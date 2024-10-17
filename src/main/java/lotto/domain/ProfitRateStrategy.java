package lotto.domain;

import lotto.constant.Prize;

import java.util.EnumMap;

public abstract class ProfitRateStrategy {

    public abstract String calculateProfitRate(EnumMap<Prize, Integer> countMap, Amount cashAmount);

}
