package lotto.service;

import lotto.model.Lotto;
import lotto.model.Lottos;

public interface ProfitStrategy {

    float calculate(Integer spendMoney , Integer rewardMoney);
}