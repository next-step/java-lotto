package lotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StatisticsReport {

    private final Map<Prize, Integer> matchCountByPrize;

    public StatisticsReport() {
        Map<Prize, Integer> matchCountByPrize = new HashMap<>();
        Arrays.stream(Prize.values()).forEach(prize -> {
            matchCountByPrize.put(prize, 0);
        });
        this.matchCountByPrize = matchCountByPrize;
    }

    public StatisticsReport(Map<Prize, Integer> matchCountByPrize) {
        this();
        for (Prize key : matchCountByPrize.keySet()) {
            this.matchCountByPrize.put(key, matchCountByPrize.get(key));
        }
    }

    public int countByPrize(Prize prize) {
        return matchCountByPrize.get(prize);
    }

    public int totalPrize() {
        int total = 0;
        for (Prize key : matchCountByPrize.keySet()) {
            if( 0 < matchCountByPrize.get(key)){
                total = total + key.prize();
            }
        }
        return total;
    }
}
