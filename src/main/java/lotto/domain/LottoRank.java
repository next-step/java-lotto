package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public enum LottoRank {
    MISS(0, 0L, (count,bonus) -> count <= 2),
    FIFTH(3, 5_000L, (count,bonus) -> count == 3),
    FOURTH(4, 50_000L, (count,bonus) -> count == 4),
    THIRD(5, 1_500_000L, (count,bonus) -> count == 5&&!bonus),
    SECOND(5, 30_000_000L, (count,bonus) -> count == 5&&bonus),
    FIRST(6, 2_000_000_000L, (count,bonus) -> count == 6);

    private final int count;
    private final long prizeMoney;
    private final BiFunction<Integer, Boolean, Boolean> expression;

    LottoRank(int count, long prizeMoney, BiFunction<Integer, Boolean, Boolean> expression) {
        this.count = count;
        this.prizeMoney = prizeMoney;
        this.expression = expression;
    }

    public static LottoRank findMatchCount(int matchNumber, boolean bonus) {
        return Arrays.stream(values())
                .filter(lottoRank -> lottoRank.match(matchNumber, bonus))
                .findFirst()
                .orElse(MISS);
    }

    private boolean match(int matchNumber, boolean bonus) {
        return this.expression.apply(matchNumber, bonus);
    }

    public long sumPrize(int count) {
        return this.prizeMoney * count;
    }

    public int count() {
        return this.count;
    }

    private boolean sameNumber(int number){
         return this.count == number;
    }

    public long prize() {
        return this.prizeMoney;
    }
}
