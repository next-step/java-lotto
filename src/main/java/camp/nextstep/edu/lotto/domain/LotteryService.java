package camp.nextstep.edu.lotto.domain;

import java.util.List;
import java.util.Set;

public interface LotteryService {
    Lotteries purchase(int investment, List<List<Integer>> numbers);

    void validate(int investment, int numberOfCustomizedLotteries);

    LotteriesReward getResult(Lotteries purchasedLotteries, Set<Integer> winningNumberSet, Integer bonusNumber);

    double calculateEarningsRate(int investment, LotteriesReward lotteriesReward);
}
