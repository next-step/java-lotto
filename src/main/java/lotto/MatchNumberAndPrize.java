package lotto;

import java.util.HashMap;
import java.util.Map;

public enum MatchNumberAndPrize {
    NON(0, 0L),
    FOURTH(3, 5_000L),
    THIRD(4, 50_000L),
    SECOND(5, 1_500_000L),
    FIRST(6, 2_000_000_000L);

    private final int matchNumber;
    private final Long prize;

    private static final Map<Integer, MatchNumberAndPrize> BY_MATCH_NUMBER = new HashMap<>();

    static {
        for (MatchNumberAndPrize matchNumberAndPrize : values()) {
            BY_MATCH_NUMBER.put(matchNumberAndPrize.matchNumber, matchNumberAndPrize);
        }
    }

    MatchNumberAndPrize(int matchNumber, Long prize) {
        this.matchNumber = matchNumber;
        this.prize = prize;
    }

    public static MatchNumberAndPrize valueOfMatchNumber(int matchNumber) {
        MatchNumberAndPrize matchNumberAndPrize = BY_MATCH_NUMBER.get(matchNumber);
        if (matchNumberAndPrize == null) return NON;
        return matchNumberAndPrize;
    }

    public static Long sumWinningAmount(Map<MatchNumberAndPrize, Integer> winningAmountIntegerMap) {
        long result = 0L;
        for (MatchNumberAndPrize matchNumberAndPrize : winningAmountIntegerMap.keySet()) {
            result += matchNumberAndPrize.prize * winningAmountIntegerMap.get(matchNumberAndPrize);
        }
        return result;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public Long getPrize() {
        return prize;
    }
}
