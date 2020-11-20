package domain;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class LottoPrizeCount {
    private Map<LottoPrize, Integer> lottoPrizeCount = new HashMap<>();

    public LottoPrizeCount() {}

    public LottoPrizeCount(Map<LottoPrize, Integer> lottoPrizeCount) {
        this.lottoPrizeCount = lottoPrizeCount;
    }

    public LottoPrizeCount incrementLottoPrize(LottoPrize lottoPrize) {
        lottoPrizeCount.put(lottoPrize, lottoPrizeCount.getOrDefault(lottoPrize, 0) + 1);
        return new LottoPrizeCount(new HashMap<>(lottoPrizeCount));
    }

    public Integer getPrizeCount(LottoPrize lottoPrize) {
        return lottoPrizeCount.getOrDefault(lottoPrize, 0);
    }

    public Stream<Map.Entry<LottoPrize, Integer>> entryStream() {
        return lottoPrizeCount.entrySet().stream();
    }
}
