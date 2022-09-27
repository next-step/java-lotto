package lotto.service.impl;

import lotto.service.ProfitStrategy;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class RelativeProfitStrategy implements ProfitStrategy {
    @Override
    public float calculate(Integer spendMoney , Integer rewardMoney) {
        return rewardMoney / spendMoney.floatValue();
    }
}