package src.domain;

import java.util.List;

public class WinningNumbers {

    private final List<GameNumber> values;

    public WinningNumbers(List<GameNumber> values) {
        this.values = values;
    }

    public Place match(List<GameNumber> gameNumbers) {
        int matchCount = 0;
        for (GameNumber gameNumber: gameNumbers) {
            if (values.contains(gameNumber)) {
                matchCount += 1;
            }
        }

        return Place.byMatchedCount(matchCount);
    }
}
