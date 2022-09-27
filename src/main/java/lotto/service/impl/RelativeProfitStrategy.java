package lotto.service.impl;

import lotto.service.ProfitStrategy;

public class RelativeProfitStrategy implements ProfitStrategy {
    @Override
    public float calculate(Integer spendMoney , Integer rewardMoney) {
        return rewardMoney / spendMoney.floatValue();
    }
}