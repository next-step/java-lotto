package camp.nextstep.edu.lotto.domain;

import java.util.Map;
import java.util.Set;

public interface LotteryService {
    Lotteries purchase(int investment);

    Map<RewardType, Integer> getResult(Lotteries purchasedLotteries, Set<Integer> winningNumberSet);

    double calculateEarningsRate(int investment, Map<RewardType, Integer> rewardMap);
}
