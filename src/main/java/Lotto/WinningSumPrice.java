package Lotto;

import java.util.stream.Stream;

public enum WinningSumPrice {

    FIRST("1th", 2000000000),
    SECOND("2th", 1500000),
    THIRD("3th", 50000),
    fourth("4th", 5000);

    private final String rank;
    private final int winningPrice;

    WinningSumPrice(String rank, int winningPrice) {
        this.rank = rank;
        this.winningPrice = winningPrice;
    }

    static WinningSumPrice findWinningRank(String Rank) {
        return Stream.of(values())
                .filter(rank -> rank.rank.equals(Rank))
                .findFirst()
                .orElseThrow();
    }

    int sum(int winningPriceNum) {
        return winningPrice * winningPriceNum;
    }

}
