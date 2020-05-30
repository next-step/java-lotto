package step2.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.function.Predicate;

public enum LottoRank {

    FIRST((count) -> count.equals(6), 2_000_000_000),
    SECOND((count) -> count.equals(5), 1_500_000),
    THIRD((count) -> count.equals(4), 50_000),
    FOURTH((count) -> count.equals(3), 5_000),
    MISS((count) -> count <= 2, 0);

    private final static EnumSet<LottoRank> WINNING_GROUP = EnumSet.of(
            LottoRank.FIRST,
            LottoRank.SECOND,
            LottoRank.THIRD,
            LottoRank.FOURTH
    );

    private final Predicate<Integer> match;
    private final int winningMoney;

    LottoRank(Predicate<Integer> match, int winningMoney) {
        this.match = match;
        this.winningMoney = winningMoney;
    }

    public static LottoRank findRank(int matchCount) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> isMatch(matchCount, lottoRank))
                .findFirst()
                .orElse(LottoRank.MISS);
    }

    public static Set<LottoRank> getWinningGroup() {
        return Collections.unmodifiableSet(WINNING_GROUP);
    }

    private static boolean isMatch(int matchCount, LottoRank lottoRank) {
        return lottoRank.match.test(matchCount);
    }

    public int getWinningMoney() {
        return this.winningMoney;
    }
}
