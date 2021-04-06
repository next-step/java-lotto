package step2.Domain;

import java.util.List;
import java.util.Map;

public class Rank {

    private Map<LottoPrize, List<Lotto>> rank;

    public Rank(Map<LottoPrize, List<Lotto>> rank) {
        this.rank = rank;
    }

    public int size(LottoPrize lottoPrize) {
        if (rank.get(lottoPrize) == null) {
            return 0;
        }
        return rank.get(lottoPrize).size();
    }

    public Map<LottoPrize, List<Lotto>> getRank() {
        return rank;
    }
}
