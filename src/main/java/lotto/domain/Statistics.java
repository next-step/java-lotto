package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistics {
    private final Map<Rank, Integer> statistics;

    public Statistics(List<Rank> ranks) {
        statistics = new HashMap<>();
    }

    public double yield(int purchaseAmount) {
        return 1.0;
    }

    public Boolean isLoss(int purchaseAmount) {
        return false;
    }
}
