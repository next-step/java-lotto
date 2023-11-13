package src.domain;

import java.util.List;

public class WinningLotto {

    private final List<GameNumber> gameNumbers;

    public WinningLotto(List<GameNumber> gameNumbers) {
        this.gameNumbers = gameNumbers;
    }

    public Place match(List<GameNumber> gameNumbers) {
        int matchCount = 0;

        for (GameNumber gameNumber: gameNumbers) {
            if (gameNumbers.contains(gameNumber)) {
                matchCount += 1;
            }
        }

        return Place.byMatchedCount(matchCount);
    }
}
