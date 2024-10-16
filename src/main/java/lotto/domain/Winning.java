package lotto.domain;

import lotto.enumeration.Rank;

public class Winning {
    private final int countMatching;
    private final int countWinning;

    public Winning(final int countMatching, final int countWinning) {
        this.countMatching = countMatching;
        this.countWinning = countWinning;
    }

    public int price() {
        return this.countWinning * Rank.price(countMatching);
    }

    public int getCountMatching() {
        return countMatching;
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
        return countMatching == winning.countMatching && countWinning == winning.countWinning;
    }
}
