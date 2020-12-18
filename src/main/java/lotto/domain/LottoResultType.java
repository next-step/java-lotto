package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public enum LottoResultType {
    SIX_MATCHED(6, false, 2_000_000_000),
    FIVE_AND_BONUS_MATCHED(5, true, 30_000_000),
    FIVE_MATCHED(5, false, 1_500_000),
    FOUR_MATCHED(4, false, 50_000),
    THREE_MATCHED(3, false, 5_000),
    TWO_MATCHED(2, false, 0),
    ONE_MATCHED(1, false, 0),
    NONE_MATCHED(0, false, 0);

    private final int matchedCount;
    private final boolean isBonus;
    private final int reward;

    LottoResultType(int matchedCount, boolean isBonus, int reward) {
        this.matchedCount = matchedCount;
        this.isBonus = isBonus;
        this.reward = reward;
    }

    public static List<LottoResultType> winningTypes() {
        return Arrays.asList(THREE_MATCHED, FOUR_MATCHED, FIVE_MATCHED, FIVE_AND_BONUS_MATCHED, SIX_MATCHED);
    }

    private static List<LottoResultType> bonusTypes() {
        return Arrays.stream(LottoResultType.values())
                .filter(LottoResultType::isBonus)
                .collect(Collectors.toList());
    }

    private static boolean isBonusType(int matchedCount) {
        return bonusTypes().stream()
                .map(LottoResultType::getMatchedCount)
                .anyMatch(value -> value == matchedCount);
    }

    private static Predicate<LottoResultType> getMatchingExpression(int matchedCount, boolean isBonus) {
        if (isBonusType(matchedCount)) {
            return lottoResultType -> lottoResultType.matchedCount == matchedCount && lottoResultType.isBonus == isBonus;
        }
        return lottoResultType -> lottoResultType.matchedCount == matchedCount;
    }

    static LottoResultType findByMatchedCountAndBonus(int matchedCount, boolean isBonus) {
        return Arrays.stream(LottoResultType.values())
                .filter(getMatchingExpression(matchedCount, isBonus))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("로또가 매칭된 숫자의 범위를 넘어섰습니다."));
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
