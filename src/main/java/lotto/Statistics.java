package lotto;

import java.util.HashMap;
import java.util.Map;

public class Statistics {
    Map<LottoWinnersEnum, Integer> statistics;

    public Statistics() {
        this.statistics = new HashMap<>(Map.of(
                LottoWinnersEnum.THREE, 0,
                LottoWinnersEnum.FOUR, 0,
                LottoWinnersEnum.FIVE, 0,
                LottoWinnersEnum.SIX, 0
        ));
    }

    public Integer get(Integer key) {
        return statistics.get(LottoWinnersEnum.findByValue(key));
    }

    public Integer get(LottoWinnersEnum key) {
        return statistics.get(key);
    }

    public void put(Integer key, Integer value) {
        this.statistics.put(LottoWinnersEnum.findByValue(key), value);
    }
}
