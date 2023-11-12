package src.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class MatchStatus {

    private final Map<Place, Integer> status;

    private final double profit;

    private MatchStatus(Map<Place, Integer> status, double profit) {
        this.status = status;
        this.profit = profit;
    }

    public static MatchStatus matchStatus(List<Integer> matchCounts) {
        Map<Place, Integer> status = new EnumMap<>(Place.class);
        for (Integer matchCount: matchCounts) {
            Place place = Place.byMatchedCount(matchCount);
            Integer winningGameCount = status.getOrDefault(place, 0);
            status.put(place, winningGameCount + 1);
        }

        return new MatchStatus(status, calculateProfit(status));
    }

    private static double calculateProfit(Map<Place, Integer> status) {
        double profit = 0.0;
        for (Map.Entry<Place, Integer> entry: status.entrySet()) {
            profit += entry.getKey().amount * entry.getValue();
        }

        return profit;
    }

    public Map<Place, Integer> status() {
        return status;
    }

    public double profit() {
        return profit;
    }
}
