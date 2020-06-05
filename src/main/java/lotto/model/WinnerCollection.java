package lotto.model;

import java.util.List;

public class WinnerCollection {

    private List<Winner> winners;

    public WinnerCollection(List<Winner> winners) {
        this.winners = winners;
    }

    public int getWinnerCount(int matchingCount) {
        return (int) winners
                        .stream()
                        .filter(o -> o.getMatchingCount() == matchingCount)
                        .count();
    }

    public int getTotalPrize() {
        return winners.stream().mapToInt(Winner::getPrize).sum();
    }


}
