package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Result {
    private static final int ONE = 1;
    private static final int ZERO = 0;
    private Map<Rank, Integer> result = new HashMap<>();

    public Result() {
        Arrays.stream(Rank.values()).forEach(rank -> result.put(rank, ZERO));
    }

    public void add(Rank winningRank) {
        result.put(winningRank, result.get(winningRank) + ONE);
    }

    public Map<Rank, Integer> getResult() {
        return result;
    }

    public double getTotalWinningPrice() {
        return Arrays.stream(Rank.values()).mapToInt(rank -> (rank.getWinningMoney() * result.get(rank))).sum();
    }

    public String getWinningRatio(long purchasedPrice) {
        return String.format("%.2f", getTotalWinningPrice() / purchasedPrice);
    }
}
