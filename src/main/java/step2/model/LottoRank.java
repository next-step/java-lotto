package step2.model;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.function.Predicate;

public enum LottoRank {

    FIRST((count) -> count.equals(6), 2_000_000_000),
    SECOND((count) -> count.equals(5), 1_500_000),
    THIRD((count) -> count.equals(4), 50_000),
    FOURTH((count) -> count.equals(3), 5_000),
    MISS((count) -> count <= 2, 0);

    public final static EnumSet<LottoRank> WINNING_GROUP = EnumSet.of(
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
                .filter(lottoRank -> lottoRank.match.test(matchCount))
                .findFirst()
                .orElse(LottoRank.MISS);
    }

    public int getWinningMoney() {
        return this.winningMoney;
    }
}
