package lotto.domain.prize;

import java.util.EnumMap;
import java.util.Map;

public class WinningPrize {

    private final Map<LottoPrize, Integer> winnings = new EnumMap<>(LottoPrize.class);

    public void record(int match) {
        LottoPrize lottoPrize = LottoPrize.from(match);
        int before = winnings.getOrDefault(lottoPrize, 0);
        winnings.put(lottoPrize, ++before);
    }

    public int winAmount(int match) {
        return winnings.getOrDefault(LottoPrize.from(match), 0);
    }

    public int totalPrize() {
        return winnings.keySet().stream()
                .mapToInt(lottoPrize -> lottoPrize.prize(winnings.get(lottoPrize)))
                .sum();
    }
}
