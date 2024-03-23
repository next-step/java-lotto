package lottogame.domain;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Rank {
    /**
     *
     * 3개 일치 (5000원)- 1개
     * 4개 일치 (50000원)- 0개
     * 5개 일치 (1500000원)- 0개
     * 6개 일치 (2_000_000_000원)- 0개
     */




    EMPTY(0, 0),
    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    FIRST(6, 2_000_000_000);

    private final int numOfWinnings;
    private final int prize;

    Rank(int numOfWinnings, int prize) {
        this.numOfWinnings = numOfWinnings;
        this.prize = prize;
    }

    public static int findPrize(int numOfWinnings) {
        return Stream.of(values())
                .filter(match(numOfWinnings))
                .findAny()
                .orElse(EMPTY)
                .prize;
    }

    public static List<Rank> getRanks() {
        return Stream.of(values())
                .filter(rank -> rank != EMPTY)
                .collect(Collectors.toList());
    }

    public static Rank findRank(int numOfWinnings) {
        return Stream.of(values())
                .filter(match(numOfWinnings))
                .findAny()
                .orElse(EMPTY);
    }

    public int getPrize() {
        return prize;
    }

    public int getNumOfWinnings() {
        return numOfWinnings;
    }

    private static Predicate<Rank> match(int numOfWinnings) {
        return rank -> rank.numOfWinnings == numOfWinnings;
    }
}
