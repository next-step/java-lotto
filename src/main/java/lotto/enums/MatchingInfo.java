package lotto.enums;

import java.util.Arrays;
import java.util.function.Predicate;

public enum MatchingInfo {

    MATCH_ZERO(0, 0, false),
    MATCH_ONE(1, 0, false),
    MATCH_TWO(2, 0, false),
    MATCH_THREE(3, 5_000, false),
    MATCH_FOUR(4, 50_000, false),
    MATCH_FIVE(5, 1_500_000, false),
    MATCH_FIVE_AND_BONUS(5, 30_000_000, true),
    MATCH_SIX(6, 2_000_000_000, false);

    private final boolean hasBonusNumber;
    private int matchingNumber;
    private int payout;

    MatchingInfo(int matchingNumber, int payout, boolean hasBonusNumber) {
        this.matchingNumber = matchingNumber;
        this.payout = payout;
        this.hasBonusNumber = hasBonusNumber;
    }

    public static MatchingInfo matchingInfo(int matchingNumber, boolean hasBonusNumber) {
        if (isMoreThanOne(matchingNumber)) {
            return matchingInfo(p -> p.matchingNumber == matchingNumber && p.hasBonusNumber == hasBonusNumber);
        }
        return matchingInfo(p -> p.matchingNumber == matchingNumber);
    }

    private static boolean isMoreThanOne(int matchingNumber) {
        return Arrays.stream(MatchingInfo.values())
                .filter(p -> p.matchingNumber == matchingNumber)
                .count() > 1;
    }

    private static MatchingInfo matchingInfo(Predicate<MatchingInfo> pedicate) {
        return Arrays.stream(MatchingInfo.values())
                .filter(pedicate)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 값을 입력해주세요"));
    }

    public int getPayout() {
        return this.payout;
    }

    public int matchingNumber() {
        return this.matchingNumber;
    }

    public boolean hasBonusNumber() {
        return this.hasBonusNumber;
    }
}
