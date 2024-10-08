package lotto.domain.prize;

import lotto.constant.LottoPrize;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class WinningPrize {

    private final Map<Integer, Prize> winnings = new LinkedHashMap<>();
    private final Prize nothing = new Prize(0, 0);

    public WinningPrize() {
        for (LottoPrize lottoPrize : LottoPrize.values()) {
            winnings.put(lottoPrize.getMatch(), new Prize(lottoPrize.getMatch(), lottoPrize.getPrize()));
        }
    }

    public void record(int match) {
        Optional.ofNullable(winnings.get(match)).orElse(nothing).add();
    }

    public int winAmount(int match) {
        return winnings.getOrDefault(match, nothing).quantity();
    }

    public int totalPrize() {
        return winnings.values().stream()
                .mapToInt(Prize::compute)
                .sum();
    }
}
