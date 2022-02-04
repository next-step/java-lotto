package lotto.domain;

import java.util.Arrays;

public enum LottoResult {
    NOMATCH(0, true, 0),
    MATCH3(3, false, 0),
    MATCH4(4, false, 0),
    MATCH5(5, false, 0),
    MATCHBONUS(5, true, 0),
    MATCH6(6, false, 0);

    private final int matchCount;
    private final boolean isBonusNumber;
    private int count;

    LottoResult(int matchCount, boolean isBonusNumber, int count) {
        this.matchCount = matchCount;
        this.isBonusNumber = isBonusNumber;
        this.count = count;
    }

    public static void upCount(int matchCount, boolean isBonusNumber) {
        Arrays.stream(values())
            .filter(result -> result.matchCount == matchCount)
            .filter(result -> result.isBonusNumber == isBonusNumber)
            .findAny()
            .orElse(NOMATCH)
            .plusCount();
    }

    public void plusCount() {
        this.count++;
    }

    public int getCount() {return this.count;}
}
