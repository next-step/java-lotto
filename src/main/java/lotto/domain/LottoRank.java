package lotto.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoRank {
    FIRST(6, null, new Money(2_000_000_000)),
    SECOND(5, true, new Money(30_000_000)),
    THIRD(5, false, new Money(1_500_000)),
    FOURTH(4, null, new Money(50_000)),
    FIFTH(3, null, new Money(5_000)),
    NONE(0, null, new Money(0))
    ;

    public static final List<LottoRank> ALL_VALUES = List.of(values());

    private final int matchCount;
    private final Boolean bonusMatched;
    private final Money reward;

    LottoRank(int matchCount, Boolean bonusMatched, Money reward) {
        this.matchCount = matchCount;
        this.bonusMatched = bonusMatched;
        this.reward = reward;
    }

    public static LottoRank of(int matchCount, boolean bonusMatched) {
        return ALL_VALUES.stream()
                .filter(rank -> equalsRank(rank, matchCount, bonusMatched))
                .findFirst()
                .orElse(NONE);
    }

    private static boolean equalsRank(LottoRank rank, int matchCount, boolean bonusMatched) {
        if (rank.bonusMatched == null) {
            return rank.matchCount == matchCount;
        }
        return rank.matchCount == matchCount && rank.bonusMatched.equals(bonusMatched);
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

    public int getMatchCount() {
        return matchCount;
    }

    public Money getReward() {
        return reward;
    }

    public boolean hasBonusNumber() {
        return bonusMatched != null && bonusMatched;
    }

}
