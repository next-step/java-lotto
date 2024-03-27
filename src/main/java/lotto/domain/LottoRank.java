package lotto.domain;

import static lotto.config.LottoExceptionMessage.LOTTO_RANK_IS_NOT_FOUND;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum LottoRank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    NONE(0, 0),
    ;

    private static final Map<Integer, LottoRank> rankMap = Arrays.stream(values())
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

    public static LottoRank from(final int matchingCount) {
        if (isNotWinning(matchingCount)) {
            return NONE;
        }

        return Optional.ofNullable(rankMap.get(matchingCount))
                .orElseThrow(() -> new IllegalArgumentException(LOTTO_RANK_IS_NOT_FOUND.message(matchingCount)));
    }

    private static boolean isNotWinning(final int matchingCount) {
        return NONE.matchingCount <= matchingCount && matchingCount < FOURTH.matchingCount;
    }
}
