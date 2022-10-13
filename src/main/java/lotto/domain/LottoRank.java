package lotto.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoRank {
    FIRST(6, new Money(2_000_000_000)),
    SECOND(5, new Money(30_000_000)),
    THIRD(5, new Money(1_500_000)),
    FOURTH(4, new Money(50_000)),
    FIFTH(3, new Money(5_000)),
    NONE(0, new Money(0))
    ;

    public static final List<LottoRank> ALL_VALUES = List.of(values());

    private final int matchCount;
    private final Money reward;

    LottoRank(int matchCount, Money reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static LottoRank of(int matchCount, boolean bonusMatched) {
        if (isSecondRank(matchCount, bonusMatched)) {
            return LottoRank.SECOND;
        }
        if (isThirdRank(matchCount, bonusMatched)) {
            return LottoRank.THIRD;
        }

        return ALL_VALUES.stream()
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElse(NONE);
    }

    private static boolean isSecondRank(int matchCount, boolean bonusMatched) {
        return matchCount == LottoRank.SECOND.matchCount && bonusMatched;
    }

    private static boolean isThirdRank(int matchCount, boolean bonusMatched) {
        return matchCount == LottoRank.THIRD.matchCount && !bonusMatched;
    }

    public static List<LottoRank> getRewardRanksReversed() {
        return getRewardRanks().stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public static List<LottoRank> getRewardRanks() {
        return ALL_VALUES.stream()
                .filter(it -> it != NONE)
                .collect(Collectors.toList());
    }

    public boolean hasBonusNumber() {
        return this == LottoRank.SECOND;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public Money getReward() {
        return reward;
    }

}
