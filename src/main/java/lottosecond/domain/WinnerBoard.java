package lottosecond.domain;

import java.util.List;
import java.util.Objects;

public class WinnerBoard {

    private final List<Winner> winners;

    public WinnerBoard(List<Winner> winners) {
        this.winners = winners;
    }

    public long calculateTotalPrice() {
        return winners.stream().mapToLong(Winner::getPrice)
                .sum();
    }

    public List<Winner> getWinners() {
        return winners;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinnerBoard that = (WinnerBoard) o;
        return Objects.equals(getWinners(), that.getWinners());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWinners());
    }
}
