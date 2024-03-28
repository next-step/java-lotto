package lottery.code;

import java.util.Arrays;
import java.util.Objects;

public enum WinPrizeType {

    THREE_MATCH (3L, 5_000),
    FOUR_MATCH (4L, 50_000),
    FIVE_MATCH (5L, 1_500_000),
    SIX_MATCH (6L, 2_000_000_000),
    NONE (0L, 0);

    private final Long matchCount;
    private final Integer prize;

    WinPrizeType(Long matchCount,
                 Integer prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public Integer prize(){
        return this.prize;
    }

    public static WinPrizeType fromMatchCount(Long matchCount) {
        return Arrays.stream(WinPrizeType.values())
                .filter(prizeType -> Objects.equals(prizeType.matchCount, matchCount))
                .findFirst()
                .orElse(NONE);
    }

}
