package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum LottoResultType {
    SIX_MATCHED(6, 2_000_000_000),
    FIVE_MATCHED(5, 1_500_000),
    FOUR_MATCHED(4, 50_000),
    THREE_MATCHED(3, 5_000),
    TWO_MATCHED(2, 0),
    ONE_MATCHED(1, 0),
    NONE_MATCHED(0, 0);

    public static final List<LottoResultType> WINNING_TYPES = Collections.unmodifiableList(Arrays.asList(THREE_MATCHED, FOUR_MATCHED, FIVE_MATCHED, SIX_MATCHED));

    private final int matchedCount;
    private final int reward;

    LottoResultType(int matchedCount, int reward) {
        this.matchedCount = matchedCount;
        this.reward = reward;
    }

    static LottoResultType findByMatchedCount(int matchedCount) {
        return Arrays.stream(LottoResultType.values())
                .filter(lottoResultType -> lottoResultType.matchedCount == matchedCount)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(String.format("매칭된 숫자(%d)가 로또 결과의 범위를 넘었습니다.", matchedCount)));
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public int getReward() {
        return reward;
    }
}
