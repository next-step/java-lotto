package lotto.domain.reward;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum LottoRank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0),
    ;

    private static final Map<Integer, LottoRank> rankMap = Arrays.stream(values())
            .filter(rank -> rank != SECOND)
            .collect(Collectors.toUnmodifiableMap(LottoRank::matchingCount, Function.identity()));

    private final int matchingCount;
    private final int rewardAmount;

    LottoRank(final int matchingCount, final int rewardAmount) {
        this.matchingCount = matchingCount;
        this.rewardAmount = rewardAmount;
    }

    public int matchingCount() {
        return this.matchingCount;
    }

    public int rewardAmount() {
        return this.rewardAmount;
    }

    public static LottoRank from(final int matchingCount, final boolean isMatchedBonus) {
        if (isNotWinning(matchingCount)) {
            return NONE;
        }

        if (isSecond(matchingCount, isMatchedBonus)) {
            return SECOND;
        }

        return Optional.ofNullable(rankMap.get(matchingCount))
                .orElseThrow(() -> new IllegalArgumentException("로또 번호 당첨 개수에 따른 순위가 존재하지 않습니다. 개수: " + matchingCount));
    }

    private static boolean isNotWinning(final int matchingCount) {
        return NONE.matchingCount <= matchingCount && matchingCount < FIFTH.matchingCount;
    }

    private static boolean isSecond(final int matchingCount, final boolean isMatchedBonus) {
        return matchingCount == SECOND.matchingCount && isMatchedBonus;
    }
}