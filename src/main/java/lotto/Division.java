package lotto;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

//FIXME: 좀더 명시적인 이름으로 변경 :)
public enum Division {
    FIRST(6, 2_000_000_000L),
    SECOND(5, 1_500_000L),
    THIRD(4, 50_000L),
    FOURTH(3, 5_000L),
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

    public static BigDecimal sumPrize(List<Division> divisions) {
        long result = 0L;
        for (Division division : divisions) {
            result += division.winnerPrize;
        }
        return BigDecimal.valueOf(result);
    }
}
