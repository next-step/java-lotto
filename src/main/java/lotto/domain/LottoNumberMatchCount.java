package lotto.domain;

import java.util.Arrays;

public enum LottoNumberMatchCount {
    NOTHING(0),
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    ALL(6);

    private final int count;

    LottoNumberMatchCount(final int count) {
        this.count = count;
    }

    public static LottoNumberMatchCount valueOf(final int count) {
        return Arrays.stream(values())
            .filter(lottoMatchResult -> lottoMatchResult.count == count)
            .findFirst()
            .orElse(LottoNumberMatchCount.NOTHING);
    }

    public int intValue() {
        return count;
    }
}
