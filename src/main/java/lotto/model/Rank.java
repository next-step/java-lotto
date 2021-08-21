package lotto.model;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Rank {
    FIRST(6, 2_000_000_000, (count, isMatch) -> count == 6),
    SECOND(5, 30_000_000, (count, isMatch) -> count == 5 && isMatch),
    THIRD(5, 1_500_000, (count, isMatch) -> count == 5 && !isMatch),
    FOURTH(4, 50_000, (count, isMatch) -> count == 4),
    FIFTH(3, 5_000, (count, isMatch) -> count == 3),
    MISS(0, 0, (count, isMatch) -> count < 3);

    private final int match;
    private final int winningBonus;
    private final BiPredicate<Integer, Boolean> matchLogic;

    Rank(int match, int winningBonus, BiPredicate<Integer, Boolean> matchLogic) {
        this.match = match;
        this.winningBonus = winningBonus;
        this.matchLogic = matchLogic;
    }

    public static Rank of(int count, boolean isMatch) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchLogic.test(count, isMatch))
                .findFirst()
                .get();
    }

    public int getMatch() {
        return match;
    }

    public int getWinningBonus() {
        return winningBonus;
    }

    public BiPredicate<Integer, Boolean> getMatchLogic() {
        return matchLogic;
    }
}
