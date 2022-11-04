package lotto;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiPredicate;

public enum Winning {

    THIRD(3, false, Money.of(5000), (winningMatchCount, bonusBallMatch) -> winningMatchCount == 3),
    FOURTH(4, false, Money.of(50000), (winningMatchCount, bonusBallMatch) -> winningMatchCount == 4),
    FIFTH(5, false, Money.of(1500000), (winningMatchCount, bonusBallMatch) -> winningMatchCount == 5 && !bonusBallMatch),
    FIFTH_BONUS(5, true, Money.of(30000000), (winningMatchCount, bonusBallMatch) -> winningMatchCount == 5 && bonusBallMatch),
    SIXTH(6, false, Money.of(2000000000), (winningMatchCount, bonusBallMatch) -> winningMatchCount == 6),
    ;

    private final int matchCount;
    private final boolean bonusBallUse;
    private final Money prize;
    private final BiPredicate<Integer, Boolean> predicate;

    Winning(int matchCount, boolean bonusBallUse, Money prize, BiPredicate<Integer, Boolean> predicate) {
        this.matchCount = matchCount;
        this.bonusBallUse = bonusBallUse;
        this.prize = prize;
        this.predicate = predicate;
    }

    public static Optional<Winning> of(int winningMatchCount, boolean bonusBallMatch) {
        return Arrays.stream(values())
                .filter(w -> w.predicate.test(winningMatchCount, bonusBallMatch))
                .findFirst();
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusBallUse() {
        return bonusBallUse;
    }

    public Money getPrize() {
        return prize;
    }
}
