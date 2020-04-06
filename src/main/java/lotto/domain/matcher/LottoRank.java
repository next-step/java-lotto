package lotto.domain.matcher;

import com.sun.tools.javac.util.Pair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum LottoRank {
    ZERO(Pair.of(0, false), 0),
    ONE(Pair.of(1, false), 0),
    TWO(Pair.of(2, false), 0),
    THREE(Pair.of(3, false), 5_000),
    FOUR(Pair.of(4, false), 50_000),
    FIVE(Pair.of(5, false), 1_500_000),
    FIVE_BONUS(Pair.of(5, true), 300_000_000),
    SIX(Pair.of(6, false), 2_000_000_000);

    private static Map<Pair, LottoRank> levels = new HashMap<>();

    static {
        levels.put(Pair.of(0, false), ZERO);
        levels.put(Pair.of(1, false), ONE);
        levels.put(Pair.of(2, false), TWO);
        levels.put(Pair.of(3, false), THREE);
        levels.put(Pair.of(4, false), FOUR);
        levels.put(Pair.of(5, false), FIVE);
        levels.put(Pair.of(5, true), FIVE_BONUS);
        levels.put(Pair.of(6, false), SIX);
    }

    private final Pair<Integer, Boolean> tier;
    private final int winningPrize;

    LottoRank(Pair<Integer, Boolean> tier, int winningPrize) {
        this.tier = tier;
        this.winningPrize = winningPrize;
    }

    public static LottoRank of(Pair<Integer, Boolean> tier) {
        return levels.getOrDefault(tier, of(tier.fst));
    }

    public static LottoRank of(int matchCount) {
        return Arrays.asList(LottoRank.values()).stream()
                .filter(lottoRank -> lottoRank.isMatch(matchCount))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("찾으시는 랭크가 존재하지 않습니다."));
    }

    public int getMatchCount() {
        return new Integer(tier.fst);
    }

    public int getWinningPrize() {
        return winningPrize;
    }

    private boolean isMatch(int matchCount) {
        return getMatchCount() == matchCount;
    }

}
