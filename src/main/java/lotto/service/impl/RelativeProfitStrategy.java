package lotto.service.impl;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.service.ProfitStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class RelativeProfitStrategy implements ProfitStrategy {
    @Override
    public float calculate(Integer spendMoney , Integer rewardMoney) {
        return 0;
    }
}