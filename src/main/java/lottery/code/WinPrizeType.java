package lottery.code;

import java.util.Arrays;
import java.util.Objects;

public enum WinPrizeType {

    FIRST (6L, 2_000_000_000),
    SECOND(5L, 30_000_000),
    THIRD (5L, 1_500_000),
    FOURTH (4L, 50_000),
    FIFTH (3L, 5_000),
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

    public static WinPrizeType fromMatchCountWithBonusMatch(Long matchCount, Boolean matchBonus) {
        if (matchBonus && matchCount == 5L)
            return SECOND;
        return Arrays.stream(WinPrizeType.values())
                .filter(prizeType -> Objects.equals(prizeType.matchCount, matchCount)
                        && prizeType != SECOND)
                .findFirst()
                .orElse(NONE);
    }

}
