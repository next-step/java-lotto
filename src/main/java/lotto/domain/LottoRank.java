package lotto.domain;

import java.util.List;

public enum LottoRank {
    FIRST(6, 200_0000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    NONE(0, 0)
    ;

    public static final List<LottoRank> ALL_VALUES = List.of(values());

    private final int matchCount;
    private final int reward;

    LottoRank(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static LottoRank from(int matchCount) {
        return ALL_VALUES.stream()
                .filter(value -> value.matchCount == matchCount)
                .findFirst()
                .orElse(NONE);
    }

}
