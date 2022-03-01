package lotto.domain;

import java.util.Arrays;

public enum LottoResult {
    NO_MATCH(0, false, 0),
    MATCH3(3, false, 5000),
    MATCH4(4, false, 5_0000),
    MATCH5(5, false, 15_0000),
    MATCH_BONUS(5, true, 3000_0000),
    MATCH6(6, false, 20_0000_0000);

    private final int matchCount;
    private final boolean isBonusNumber;
    private final int winning;

    LottoResult(int matchCount, boolean isBonusNumber, int winning) {
        this.matchCount = matchCount;
        this.isBonusNumber = isBonusNumber;
        this.winning = winning;
    }

    public static LottoResult findLottoResult(int matchCount, boolean isBonusNumber) {
        return Arrays.stream(values())
            .filter(lottoResult -> lottoResult.isResult(matchCount, isBonusNumber))
            .findAny()
            .orElse(NO_MATCH);
    }

    private Boolean isResult(int matchCount, boolean isBonusNumber) {
        if (matchCount == 5 && this.matchCount == 5) {
            return this.isBonusNumber == isBonusNumber;
        }
        return this.matchCount == matchCount;
    }

    public int getWinning() {
        return this.winning;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusNumber() {
        return isBonusNumber;
    }
}
