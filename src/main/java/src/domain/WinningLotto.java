package src.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningLotto {

    private final List<GameNumber> winningNumbers;

    public WinningLotto(List<GameNumber> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public Place match(List<GameNumber> gameNumbers) {
        Map<Boolean, Integer> matchStatus = new HashMap<>(2);

        for (GameNumber gameNumber: gameNumbers) {
            Integer value = matchStatus.getOrDefault(winningNumbers.contains(gameNumber), 0);
            matchStatus.put(winningNumbers.contains(gameNumber), value + 1);
        }

        return Place.byMatchedCount(matchStatus.get(Boolean.TRUE));
    }
}
