package lottery.domain;

import java.util.Arrays;

public enum MatchCount {

    SIX_MATCH(6),
    FIVE_MATCH(5),
    FOUR_MATCH(4),
    THREE_MATCH(3);

    private final Integer count;

    MatchCount(Integer count) {
        this.count = count;
    }

    public static MatchCount valueOf(int count) {
        return Arrays.stream(MatchCount.values())
                .filter(matchCount -> matchCount.count == count)
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}
