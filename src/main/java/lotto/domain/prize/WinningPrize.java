package lotto.domain.prize;

import lotto.constant.Prize;

import java.util.EnumMap;
import java.util.Map;

public class WinningPrize {

    private final Map<Prize, Integer> winnings = new EnumMap<>(Prize.class);

    public void add(Prize prize) {
        Integer before = winnings.getOrDefault(prize, 0);
        winnings.put(prize, ++before);
    }

    public int winAmount(Prize prize) {
        return winnings.getOrDefault(prize, 0);
    }

    public int totalPrize() {
        return winnings.keySet().stream()
                .mapToInt(prize -> prize.getPrize() * winnings.get(prize))
                .sum();
    }
}
