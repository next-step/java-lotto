package step2.lotto;

import java.util.EnumSet;

enum Rank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    NOTHING(0, 0),
    ;

    private final long numberOfMatchingNumbers;
    private final double prizeAmount;

    Rank(long numberOfMatchingNumbers, double prizeAmount) {
        this.numberOfMatchingNumbers = numberOfMatchingNumbers;
        this.prizeAmount = prizeAmount;
    }

    public static double prizeAmount(long numberOfMatchingNumbers) {
        return EnumSet.allOf(Rank.class)
                .stream()
                .filter(rank -> rank.numberOfMatchingNumbers == numberOfMatchingNumbers)
                .map(rank -> rank.prizeAmount)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("일치하는 개수가 3 ~ 6 개기어야 합니다."));
    }

    public static Rank rank(long numberOfMatchingNumbers) {
        return EnumSet.allOf(Rank.class)
                .stream()
                .filter(rank -> rank.numberOfMatchingNumbers == numberOfMatchingNumbers)
                .findFirst()
                .orElse(Rank.NOTHING);
    }

}
