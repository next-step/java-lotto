package lotto;

import java.util.Arrays;
import java.util.List;

public enum Division {
    FIRST(6, 5000L),
    SECOND(5, 50000L),
    THIRD(4, 1500000L),
    FOURTH(3, 2000000000L),
    NO_DIVISION(0, 0L);

    private final int matchedCount;
    private final long winnerPrize;

    Division(int matchedCount, long winnerPrize) {
        this.matchedCount = matchedCount;
        this.winnerPrize = winnerPrize;
    }

    public static Division valueOf(final int matchedCount) {
        return Arrays.stream(Division.values())
            .filter(division -> division.matchedCount == matchedCount)
            .findFirst()
            .orElse(NO_DIVISION);
    }
    
    public static long sumPrize(List<Division> divisions){
        long result = 0L;
        for (Division division : divisions) {
            result += division.winnerPrize;
        }
        return result;
    }
}
