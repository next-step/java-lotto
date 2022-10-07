package lotto.domain;

import java.util.List;

public enum LottoRank {
    FIRST(6, new Money(2_000_000_000)),
    SECOND(5, new Money(1_500_000)),
    THIRD(4, new Money(50_000)),
    FOURTH(3, new Money(5_000)),
    NONE(0, new Money(0))
    ;

    public static final List<LottoRank> ALL_VALUES = List.of(values());

    private final int matchCount;
    private final Money reward;

    LottoRank(int matchCount, Money reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static LottoRank from(int matchCount) {
        return ALL_VALUES.stream()
                .filter(value -> value.matchCount == matchCount)
                .findFirst()
                .orElse(NONE);
    }

    public Money getReward() {
        return reward;
    }

}
