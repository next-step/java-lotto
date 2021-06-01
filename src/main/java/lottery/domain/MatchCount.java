package lottery.domain;

import java.util.Arrays;

public enum MatchCount {

    SIX(6),
    FIVE(5),
    FOUR(4),
    THREE(3),
    ZERO(0);

    private final Integer count;

    MatchCount(Integer count) {
        this.count = count;
    }

    public static MatchCount valueOf(int count) {
        return Arrays.stream(MatchCount.values())
                .filter(matchCount -> matchCount.count == count)
                .findAny()
                .orElse(ZERO);
    }

    public Integer getCount() {
        return count;
    }
}
