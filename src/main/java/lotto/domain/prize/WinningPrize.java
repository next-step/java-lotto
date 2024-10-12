package lotto.domain.prize;

import java.util.EnumMap;
import java.util.Map;

public class WinningPrize {

    private static final int NONE = 0;

    private final Map<LottoPrize, Integer> winnings = new EnumMap<>(LottoPrize.class);

    public void record(LottoPrize lottoPrize) {
        int before = winnings.getOrDefault(lottoPrize, 0);
        winnings.put(lottoPrize, ++before);
    }

    public int winAmount(LottoPrize lottoPrize) {
        return winnings.getOrDefault(lottoPrize, NONE);
    }

    public long totalPrize() {
        return winnings.keySet().stream()
                .mapToLong(lottoPrize -> lottoPrize.prize(winnings.get(lottoPrize)))
                .sum();
    }
}
