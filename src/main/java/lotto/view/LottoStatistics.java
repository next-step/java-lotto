package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.type.MatchType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoStatistics {

    private final int quantity;
    private final Map<Integer, Integer> store = new HashMap<>();

    public LottoStatistics(int quantity, List<Integer> matchCounts) {
        this.quantity = quantity;
        matchCounts.forEach(i -> store.put(i, store.getOrDefault(i, 0) + 1));
    }

    public String benefit() {
        int prize = getAllPrize();
        if (prize == 0) {
            return "0";
        }

        return String.format("%.2f", prize / (Lotto.PRICE * (double) quantity));
    }

    private int getAllPrize() {
        int sum = 0;
        for (MatchType type : MatchType.values()) {
            sum += type.prize(getMatchCount(type));
        }

        return sum;
    }

    public int getMatchCount(MatchType type) {
        return store.getOrDefault(type.matchCount(), 0);
    }
}
