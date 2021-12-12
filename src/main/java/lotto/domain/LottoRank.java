package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoRank {
    SIX_MATCHED(6, 2_000_000_000, true),
    FIVE_MATCHED(5, 1_500_000, true),
    FOUR_MATCHED(4, 50_000, true),
    THREE_MATCHED(3, 5_000, true),
    TWO_MATCHED(2, 0, false),
    ONE_MATCHED(1, 0, false),
    NONE_MATCHED(0, 0, false);

    public static final List<LottoRank> WINNING_TYPES = Collections.unmodifiableList(
            Arrays.stream(LottoRank.values())
                    .filter(value -> value.winningType)
                    .sorted(Comparator.reverseOrder())
                    .collect(Collectors.toList()));

    private final int matchedCount;
    private final int reward;
    private final boolean winningType;

    LottoRank(int matchedCount, int reward, boolean winningType) {
        this.matchedCount = matchedCount;
        this.reward = reward;
        this.winningType = winningType;
    }

    public static LottoRank findByMatchedCount(int matchedCount) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.matchedCount == matchedCount)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(String.format("매칭된 숫자(%d)가 로또 결과의 범위를 넘었습니다.", matchedCount)));
    }

    public int matchedCount() {
        return matchedCount;
    }

    public int reward() {
        return reward;
    }
}
