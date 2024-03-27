package lottery.code;

import java.util.Arrays;
import java.util.Objects;

public enum WinPrizeType {

    THREE_MATCH (3L, 5000),
    FOUR_MATCH (4L, 50000),
    FIVE_MATCH (5L, 1500000),
    SIX_MATCH (6L, 2000000000),
    NONE (null, 0);

    private final Long matchCount;
    private final int prize;

    WinPrizeType(Long matchCount,
                 int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int prize(){
        return this.prize;
    }

    public static WinPrizeType fromMatchCount(Long matchCount) {
        return Arrays.stream(WinPrizeType.values())
                .filter(prizeType -> Objects.equals(prizeType.matchCount, matchCount))
                .findFirst()
                .orElse(NONE);
    }

}
