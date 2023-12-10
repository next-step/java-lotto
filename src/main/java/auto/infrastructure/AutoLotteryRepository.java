package auto.infrastructure;

import java.util.List;

public interface AutoLotteryRepository {
    List<List<Integer>> createLotteryNumbersList(int lotteryCount);
}
