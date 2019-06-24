package camp.nextstep.edu.lotto.view;

import camp.nextstep.edu.lotto.domain.Lottery;
import camp.nextstep.edu.lotto.domain.RewardType;

import java.util.List;
import java.util.Map;

public interface ResultView {
    void printPurchasedLotteries(List<Lottery> lotteries);

    void printResults(Map<RewardType, Integer> rewardMap, double earningsRate);
}
