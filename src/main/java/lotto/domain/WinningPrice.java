package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum WinningPrice {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0)
    ;

    private final int matchingCount;
    private final int winningPrice;

    WinningPrice(int matchingCount, int winningPrice) {
        this.matchingCount = matchingCount;
        this.winningPrice = winningPrice;
    }

    public static WinningPrice decideWithMatchingCount(int matchingNumberCount) {
        return Arrays.stream(values())
                .filter(value -> value.getMatchingCount() == matchingNumberCount)
                .findFirst()
                .orElse(MISS);
    }

    private static WinningPrice secondOrThird(boolean containBonusNumber) {
        if(containBonusNumber){
            return WinningPrice.SECOND;
        }
        return WinningPrice.THIRD;
    }

    public static WinningPrice decideGrade(MatchingResult matchingResult) {
        if(matchingResult.getMatchingCount() == 5){
            return secondOrThird(matchingResult.isIncludeBonusNumber());
        }
        return Arrays.stream(values())
                .filter(value -> value.getMatchingCount() == matchingResult.getMatchingCount())
                .findFirst()
                .orElse(MISS);
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getWinningPrice() {
        return winningPrice;
    }
}
