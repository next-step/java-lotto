package camp.nextstep.edu.lotto.domain;

import java.util.Set;

public interface LotteryService {
    Lotteries purchase(int investment);

    LotteriesReward getResult(Lotteries purchasedLotteries, Set<Integer> winningNumberSet);

    double calculateEarningsRate(int investment, LotteriesReward lotteriesReward);
}
