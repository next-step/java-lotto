package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoGrade {
    NOMATCH(0, false, 0),
    GRADE5(3, false, 5000),
    GRADE4(4, false, 50000),
    GRADE3(5, false, 150000),
    GRADE2(5, true, 30000000),
    GRADE1(6, false, 2000000000);

    private final int matchCount;
    private final boolean isBonusNumber;
    private final int winningPrice;

    LottoGrade(int matchCount, boolean isBonusNumber, int winningPrice) {
        this.matchCount = matchCount;
        this.isBonusNumber = isBonusNumber;
        this.winningPrice = winningPrice;
    }

    public static String findLottoHash(int matchCount, boolean isBonusNumber) {
        return Arrays.stream(values())
            .filter(lottoResult -> lottoResult.matchCount == matchCount)
            .filter(lottoResult -> lottoResult.isBonusNumber == isBonusNumber)
            .findAny()
            .orElse(NOMATCH)
            .name();
    }

    public static List<LottoGrade> toList() {
        return Arrays.stream(values()).collect(Collectors.toList());
    }

    public boolean isBonusNumber() {
        return isBonusNumber;
    }

    public String getName() {
        return name();
    }

    public int getWinningPrice() {
        return this.winningPrice;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
