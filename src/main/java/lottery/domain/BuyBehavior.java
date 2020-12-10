package lottery.domain;

import java.util.List;

public interface BuyBehavior {
    List<LotteryNumber> getLotteryNumbers(int pickCounts);
}
