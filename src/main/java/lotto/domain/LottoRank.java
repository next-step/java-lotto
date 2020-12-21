package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoRank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FORTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    TWO_MATCHED(2, false, 0),
    ONE_MATCHED(1, false, 0),
    NONE_MATCHED(0, false, 0);

    private final int matchedCount;
    private final boolean isBonus;
    private final int reward;

    LottoRank(int matchedCount, boolean isBonus, int reward) {
        this.matchedCount = matchedCount;
        this.isBonus = isBonus;
        this.reward = reward;
    }

    public static List<LottoRank> winningTypes() {
        return Arrays.asList(FIFTH, FORTH, THIRD, SECOND, FIRST);
    }

    static LottoRank findByMatchedCountAndBonus(int matchedCount, boolean isBonus) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.isMatched(matchedCount, isBonus))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("로또가 매칭된 숫자의 범위를 넘어섰습니다."));
    }

    private boolean isMatched(int matchedCount, boolean isBonus) {
        if (isBonusType(matchedCount)) {
            return this.matchedCount == matchedCount && this.isBonus == isBonus;
        }
        return this.matchedCount == matchedCount;
    }

    private boolean isBonusType(int matchedCount) {
        return bonusTypes().stream()
                .map(LottoRank::getMatchedCount)
                .anyMatch(value -> value == matchedCount);
    }

    private List<LottoRank> bonusTypes() {
        return Arrays.stream(LottoRank.values())
                .filter(LottoRank::isBonus)
                .collect(Collectors.toList());
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public boolean isBonus() {
        return isBonus;
    }

    public int getReward() {
        return reward;
    }
}
