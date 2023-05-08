package lotto.Model;

import java.util.HashMap;

public class GameResult {
    private static final int WINNER_MATCH_COUNT_MIN = 3;
    private static final int WINNER_MATCH_COUNT_MAX = 6;
    private static final int CANDIDATE_BONUS_COUNT = 5;
    private static final int BONUS_CATEGORY = 15;
    private static final int COUNT_INIT = 0;
    private static final int COUNT_INCREMENT = 1;

    private static HashMap<Integer, Integer> resultTable = new HashMap<>();

    public GameResult() {
        resultTable = resultFormat();
    }

    private HashMap<Integer, Integer> resultFormat() {
        HashMap<Integer, Integer> result = new HashMap<>();
        for (int i = WINNER_MATCH_COUNT_MIN; i <= WINNER_MATCH_COUNT_MAX; i++) {
            result.put(i, COUNT_INIT);
        }
        result.put(BONUS_CATEGORY, COUNT_INIT);

        return result;
    }

    public HashMap<Integer, Integer> table() {
        return resultTable;
    }

    public void addCount(int countMatchedNumber, boolean isBonus) {
        if (countMatchedNumber < WINNER_MATCH_COUNT_MIN) {
            return;
        }

        if (countMatchedNumber == CANDIDATE_BONUS_COUNT && isBonus) {
            countMatchedNumber = BONUS_CATEGORY;
        }

        resultTable.put(countMatchedNumber, resultTable.get(countMatchedNumber) + COUNT_INCREMENT);
    }

    public int countOfTicketByRank(int rank) {
        if (rank == 2) {
            return resultTable.get(BONUS_CATEGORY);
        }

        if (rank == 1) {
            return resultTable.get(WINNER_MATCH_COUNT_MAX);
        }

        return resultTable.get(WINNER_MATCH_COUNT_MAX - rank + 2);
    }
}
