package src.domain;

import java.util.Map;
import java.util.TreeMap;

public class MatchStatus {

    private final Map<Place, Integer> status;

    private MatchStatus(Map<Place, Integer> status) {
        this.status = status;
    }

    public static MatchStatus of(Map<Place, Integer> status) {
        return new MatchStatus(status);
    }

    public double profit() {
        double profit = 0.0;
        for (Map.Entry<Place, Integer> entry: status.entrySet()) {
            profit += entry.getKey().amount * entry.getValue();
        }

        return profit;
    }

    public double profitRate(double priceOfLotto) {
        int totalLottoCount = status.values().stream().mapToInt(Integer::intValue).sum();

        return profit() / (totalLottoCount * priceOfLotto);
    }

    public Map<Place, Integer> status() {
        return new TreeMap<>(status);
    }
}
