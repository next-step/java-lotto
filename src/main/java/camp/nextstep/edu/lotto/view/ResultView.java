package camp.nextstep.edu.lotto.view;

import camp.nextstep.edu.lotto.domain.Lotteries;
import camp.nextstep.edu.lotto.domain.RewardType;

import java.util.Map;

public interface ResultView {
    void printPurchasedLotteries(Lotteries lotteries);

    void printResults(Map<RewardType, Integer> rewardMap, double earningsRate);
}
