package lotto.domain.enums;

import java.util.Arrays;
import java.util.stream.Stream;

public enum LottoMatcher {

    MATCH_ZERO(0, 0),
    MATCH_THREE(3, 5_000),
    MATCH_FOUR(4, 50_000),
    MATCH_FIVE(5, 1_500_000),
    MATCH_SIX(6, 2_000_000_000);

    private final long matchCount;
    private final int winningBonus;

    LottoMatcher(long matchCount, int winningBonus) {
        this.matchCount = matchCount;
        this.winningBonus = winningBonus;
    }

    public static LottoMatcher match(Long matchCount) {
        return Arrays.stream(LottoMatcher.values())
                .filter(lottoMatcher -> lottoMatcher.matchCount == matchCount)
                .findFirst()
                .orElse(MATCH_ZERO);
    }

    public static Stream<LottoMatcher> getLottoBoardMatcher() {
        return Stream.of(MATCH_THREE, MATCH_FOUR, MATCH_FIVE, MATCH_SIX);
    }

    public long getMatchCount() {
        return matchCount;
    }

    public int getWinningBonus() {
        return winningBonus;
    }
}
