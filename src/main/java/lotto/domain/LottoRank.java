package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public enum LottoRank {
    FIRST(6, 2_000_000_000, true, false),
    SECOND(5, 30_000_000, true, true),
    THIRD(5, 1_500_000, true, false),
    FOURTH(4, 50_000, true, false),
    FIFTH(3, 5_000, true, false),
    TWO_MATCHED(2, 0, false, false),
    ONE_MATCHED(1, 0, false, false),
    NONE_MATCHED(0, 0, false, false);

    public static final List<LottoRank> WINNING_TYPES = Collections.unmodifiableList(
            Arrays.stream(LottoRank.values())
                    .filter(value -> value.winningType)
                    .sorted(Comparator.reverseOrder())
                    .collect(Collectors.toList()));

    public static final List<LottoRank> BONUS_TYPES = Collections.unmodifiableList(
            Arrays.stream(LottoRank.values())
                    .filter(value -> value.bonus)
                    .collect(Collectors.toList()));

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

    public boolean notBonus() {
        return !bonus;
    }

    private static Predicate<LottoRank> matchingExpression(int matchedCount, boolean bonus) {
        if (bonus(matchedCount)) {
            return lottoRank -> lottoRank.matchedCount == matchedCount && lottoRank.bonus == bonus;
        }
        return lottoRank -> lottoRank.matchedCount == matchedCount;
    }

    private static boolean bonus(int matchedCount) {
        return BONUS_TYPES.stream()
                .map(LottoRank::matchedCount)
                .anyMatch(v -> v == matchedCount);
    }
}
