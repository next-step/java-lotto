package lotto.domain;

import java.util.*;

public class Result {
    private List<Rank> result;
    private static final String DIGIT = "%.2f";

    public Result() {
        result = new ArrayList<>();
    }

    public void add(Rank winningRank) {
        result.add(winningRank);
    }

    public List<Rank> getResult() {
        return result;
    }

    public double getTotalWinningPrice() {
        return result.stream().mapToInt(rank -> rank.getWinningMoney()).sum();
    }

    public String getWinningRatio(long purchasedPrice) {
        return String.format(DIGIT, getTotalWinningPrice() / purchasedPrice);
    }
}
