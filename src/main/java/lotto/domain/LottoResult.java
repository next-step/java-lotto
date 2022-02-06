package lotto.domain;

import java.util.Arrays;

public enum LottoResult {
    NOMATCH(0, true, 0, 0),
    MATCH3(3, false, 0, 5000),
    MATCH4(4, false, 0, 50000),
    MATCH5(5, false, 0, 150000),
    MATCH_BONUS(5, true, 0, 30000000),
    MATCH6(6, false, 0, 2000000000);

    private final int matchCount;
    private final boolean isBonusNumber;
    private int count;
    private final int winning;

    LottoResult(int matchCount, boolean isBonusNumber, int count, int winning) {
        this.matchCount = matchCount;
        this.isBonusNumber = isBonusNumber;
        this.count = count;
        this.winning = winning;
    }

    public static void increaseMatch(int matchCount, boolean isBonusNumber) {
        findLottoResult(matchCount, isBonusNumber).plusCount();
    }

    public static LottoResult findLottoResult(int matchCount, boolean isBonusNumber) {
        return Arrays.stream(values())
            .filter(lottoResult -> lottoResult.matchCount == matchCount)
            .filter(lottoResult -> lottoResult.isBonusNumber == isBonusNumber)
            .findAny()
            .orElse(NOMATCH);
    }

    public void plusCount() {
        this.count++;
    }

    public int getCount() {
        return this.count;
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
