package lotto.domain;

import java.util.Arrays;
import java.util.function.Predicate;

public enum LottoRank {
    FIRST(6, 2_000_000_000, true, false),
    SECOND(5, 30_000_000, true, true),
    THIRD(5, 1_500_000, true, false),
    FOURTH(4, 50_000, true, false),
    FIFTH(3, 5_000, true, false),
    TWO_MATCHED(2, 0, false, false),
    ONE_MATCHED(1, 0, false, false),
    NONE_MATCHED(0, 0, false, false);

    private final int matchedCount;
    private final int reward;
    private final boolean winningType;
    private final boolean bonus;

    LottoRank(int matchedCount, int reward, boolean winningType, boolean bonus) {
        this.matchedCount = matchedCount;
        this.reward = reward;
        this.winningType = winningType;
        this.bonus = bonus;
    }

    public static LottoRank findByMatchedCountAndBonus(int matchedCount, boolean bonus) {
        return Arrays.stream(LottoRank.values())
                .filter(matchingExpression(matchedCount, bonus))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(String.format("매칭된 숫자(%d)가 로또 결과의 범위를 넘었습니다.", matchedCount)));
    }

    public int matchedCount() {
        return matchedCount;
    }

    public int reward() {
        return reward;
    }

    public boolean isWinningType() {
        return winningType;
    }

    public boolean hasBonus() {
        return bonus;
    }

    public boolean hasNotBonus() {
        return !hasBonus();
    }

    private static Predicate<LottoRank> matchingExpression(int matchedCount, boolean bonus) {
        if (hasBonus(matchedCount)) {
            return lottoRank -> lottoRank.matchedCount == matchedCount && lottoRank.bonus == bonus;
        }
        return lottoRank -> lottoRank.matchedCount == matchedCount;
    }

    private static boolean hasBonus(int matchedCount) {
        return Arrays.stream(LottoRank.values())
                .filter(LottoRank::hasBonus)
                .map(LottoRank::matchedCount)
                .anyMatch(v -> v == matchedCount);
    }
}
