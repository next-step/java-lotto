package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2_000_000_000, (count, bonusNumber) -> count == 6),
    SECOND(5, 30_000_000, (count, bonusNumber) -> count == 5 && bonusNumber),
    THIRD(5, 1_500_000, (count, bonusNumber) -> count == 5 && !bonusNumber),
    FOURTH(4, 50_000, (count, bonusNumber) -> count == 4),
    FIFTH(3, 5_000, (count, bonusNumber) -> count == 3),
    NOT_MATCH(0, 0, (count, bonusNumber) -> count < 3);

    private int matchCount;
    private int winning;
    private WinningStratedy winningStratedy;

    LottoRank(int matchCount, int winning, WinningStratedy winningStratedy) {
        this.matchCount = matchCount;
        this.winning = winning;
        this.winningStratedy = winningStratedy;
    }

    public static LottoRank find(long matchCount, boolean matchBonusNumber) {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank.winningStratedy.isWinning(matchCount, matchBonusNumber))
                .findFirst()
                .orElse(NOT_MATCH);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinning() {
        return winning;
    }
}
