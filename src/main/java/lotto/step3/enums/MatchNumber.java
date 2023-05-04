package lotto.step3.enums;

import lotto.step3.domain.Result;
import lotto.step3.domain.TotalReturn;

import java.util.Arrays;
import java.util.Optional;

public enum MatchNumber {
    FIFTH(3, 5_000, "3개 일치 (5,000원)- "),
    FOURTH(4, 50_000, "4개 일치 (50,000원)- "),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원)- "),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치(30,000,000원)- "),
    FIRST(6, 200_000_000, "6개 일치 (2,000,000,000원)- ");

    private final int matchNumber;
    private final int matchPrize;
    private final String matchText;

    MatchNumber(int matchNumber, int matchPrize, String matchText) {
        this.matchNumber = matchNumber;
        this.matchPrize = matchPrize;
        this.matchText = matchText;
    }

    public long getMatchNumber() {
        return matchNumber;
    }

    public int getMatchPrize() {
        return matchPrize;
    }

    public String getMatchText() {
        return matchText;
    }

    public static Optional<MatchNumber> getMatchStat(long expectNumber) {
        return Arrays.stream(MatchNumber.values())
                .filter(e -> e.getMatchNumber() == expectNumber)
                .findFirst();
    }

    public static TotalReturn getTotalReturnResult(Result result, int cost) {
        return new TotalReturn(result.profit(cost));
    }

    public static Optional<MatchNumber> isMatchedSize(int size) {
        return Arrays.stream(MatchNumber.values())
                .filter(m -> m.getMatchNumber() == size)
                .findFirst();
    }
}

