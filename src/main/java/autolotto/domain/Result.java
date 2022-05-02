package autolotto.domain;

import java.util.Objects;

public class Result {
    private final int numberOfWins;
    private final long prize;
    private int winners;

    public Result(int numberOfWins, long prize) {
        this(numberOfWins, prize, 0);
    }

    public Result(int numberOfWins, long prize, int winners) {
        this.numberOfWins = numberOfWins;
        this.prize = prize;
        this.winners = winners;
    }

    public boolean isMatch(int numberOfWins) {
        return this.numberOfWins == numberOfWins;
    }

    public void plusWinners() {
        winners++;
    }

    public int getWinners() {
        return winners;
    }

    public long prize() {
        return prize * winners;
    }

    public int getNumberOfWins() {
        return numberOfWins;
    }

    public long getPrize() {
        return prize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return numberOfWins == result.numberOfWins && prize == result.prize && winners == result.winners;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfWins, prize, winners);
    }
}
