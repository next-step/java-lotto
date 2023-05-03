package lotto.domain;

import java.util.Map;

public interface LottoRewardStrategy {
    Map<Integer, Integer> getReward();
}
