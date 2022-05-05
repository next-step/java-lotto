package lotto.domain;

import java.util.Arrays;

public enum LottoPrize {
    FIRST(new Match(6), new Amount(2_000_000_000), false),
    SECOND(new Match(5), new Amount(30_000_000), true),
    THIRD(new Match(5), new Amount(1_500_000), false),
    FOURTH(new Match(4), new Amount(50_000), false),
    FIFTH(new Match(3), new Amount(5_000), false),
    NONE(new Match(0), new Amount(0), false);

    private final Match match;
    private final Amount amount;
    private final boolean hasBonusNumber;

    LottoPrize(Match match, Amount amount, boolean hasBonusNumber) {
        this.match = match;
        this.amount = amount;
        this.hasBonusNumber = hasBonusNumber;
    }

    public static LottoPrize of(Match match, Boolean containsBonusNumber) {
        return Arrays.stream(LottoPrize.values())
                .filter(lottoPrize -> lottoPrize.isSameMatch(match))
                .filter(lottoPrize -> !lottoPrize.hasBonusNumber || containsBonusNumber)
                .findFirst()
                .orElse(NONE);
    }

    private boolean isSameMatch(Match match) {
        return this.match.equals(match);
    }

    public boolean hasBonusNumber() {
        return hasBonusNumber;
    }

    public Match getMatch() {
        return match;
    }

    public long getAmount() {
        return amount.getAmount();
    }
}
