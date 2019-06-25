package camp.nextstep.edu.lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface LotteryService {
    List<Lottery> purchase(int investment);

    Map<RewardType, Integer> getResult(List<Lottery> purchasedLotteries, Set<Integer> winningNumberSet);

    double calculateEarningsRate(int investment, Map<RewardType, Integer> rewardMap);
}
