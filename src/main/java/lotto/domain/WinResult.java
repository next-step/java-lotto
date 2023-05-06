package lotto.domain;

import java.util.List;

public class WinResult {

    private static final int ZERO = 0;

    private final List<Rank> ranks;

    public WinResult(final List<Rank> ranks) {
        this.ranks = ranks;
    }

    public int winCount(final Rank rank) {
        return (int) ranks.stream()
                .filter(rankResult -> rankResult.equals(rank))
                .count();
    }

    public double rateOfResult() {
        return winMoney() == ZERO ? ZERO : winMoney() / buyMoney();
    }

    public int buyMoney() {
        return ranks.size() * Shop.LOTTO_PRICE;
    }

    public int winMoney() {
        return ranks.stream()
                .mapToInt(rank -> rank.winnings())
                .sum();
    }

}
