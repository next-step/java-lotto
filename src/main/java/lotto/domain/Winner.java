package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class Winner {
    public static final int FORWARD_WINNER = 2;
    private Map<Integer, Integer> winnerMap;

    public Winner() {
        this.winnerMap = new HashMap<>();
    }
    public void addWinner(int rightNumber) {
        if (isWinner(rightNumber)) {
            winnerMap.put(rightNumber, winnerMap.getOrDefault(rightNumber, 0) + 1);
        }
    }

    private boolean isWinner(final int rightNumber) {
        return rightNumber > FORWARD_WINNER;
    }

    public int getWinnerCount(int winnerNumber) {
        return winnerMap.getOrDefault(winnerNumber, 0);
    }
}
