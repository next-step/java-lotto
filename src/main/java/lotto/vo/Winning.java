package lotto.vo;

import lotto.enumeration.Rank;

public class Winning implements Comparable<Winning> {
    private final Rank rank;
    private final int countWinning;

    public Winning(final Rank rank, Integer countWinning) {
        if (countWinning == null) {
            countWinning = 0;
        }
        this.rank = rank;
        this.countWinning = countWinning;
    }

    public Rank getRank() {
        return rank;
    }

    public int getCountWinning() {
        return countWinning;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Winning winning = (Winning) o;
        return countWinning == winning.countWinning && rank == winning.rank;
    }

    @Override
    public int compareTo(final Winning other) {
        return rank.compareTo(other.getRank());
    }
}
