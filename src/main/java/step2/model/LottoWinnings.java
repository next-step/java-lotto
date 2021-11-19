package step2.model;

import java.util.Map;

public enum LottoWinnings {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    private final int matchCount;
    private final int winnings;

    LottoWinnings(int matchCount, int winnings) {
        this.matchCount = matchCount;
        this.winnings = winnings;
    }

    public int getWinnings() {
        return winnings;
    }

    public static int getYield(Map<Integer, Integer> winners) {
        int yield = 0;
        for (Integer matchCount : winners.keySet()) {
            Integer winnerCount = winners.get(matchCount);
            yield += getWinning(matchCount) * winnerCount;
        }
        return yield;
    }

    private static int getWinning(int matchCount) {
        if (matchCount == THREE.matchCount) {
            return THREE.winnings;
        }
        if (matchCount == FOUR.matchCount) {
            return FOUR.winnings;
        }
        if (matchCount == FIVE.matchCount) {
            return FIVE.winnings;
        }
        if (matchCount == SIX.matchCount) {
            return SIX.winnings;
        }
        throw new InvalidLottoMatchCountException();
    }
}
