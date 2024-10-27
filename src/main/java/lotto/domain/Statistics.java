package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class Statistics {
    private final Map<LottoWinners, Integer> statistics;

    public Statistics() {
        this.statistics = new HashMap<>(Map.of(
                LottoWinners.THREE, 0,
                LottoWinners.FOUR, 0,
                LottoWinners.FIVE, 0,
                LottoWinners.SIX, 0
        ));
    }

    public int get(int key) {
        return statistics.get(LottoWinners.findByValue(key));
    }

    public int get(LottoWinners key) {
        return statistics.get(key);
    }

    public void put(int key, int value) {
        this.statistics.put(LottoWinners.findByValue(key), value);
    }
}
