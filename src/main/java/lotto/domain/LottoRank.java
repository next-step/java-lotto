package lotto.domain;

import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum LottoRank {
    LOSE(0, false, 0),
    FOURTH(3,false, 5_000),
    THIRD(4, false, 50_000),
    SECOND(5, false, 1_500_000),
    SECOND_BONUS(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);

    private static final Map<SimpleEntry<Integer, Boolean>, LottoRank> LOTTO_RANK_MAP = new HashMap<>();

    static {
        Arrays.stream(LottoRank.values())
                .forEach(lottoRank -> LOTTO_RANK_MAP.put(new SimpleEntry<>(lottoRank.matches, lottoRank.isBonusMatched), lottoRank));
    }

    private final int matches;
    private final boolean isBonusMatched;
    private final int prize;

    LottoRank(int matches, boolean isBonusMatched, int prize) {
        this.matches = matches;
        this.isBonusMatched = isBonusMatched;
        this.prize = prize;
    }

    public int getPrize() {
        return this.prize;
    }

    public static LottoRank getLottoRank(int matches) {
        return getLottoRank(matches, false);
    }

    public static LottoRank getLottoRank(int matches, boolean isBonusMatched) {
        return LOTTO_RANK_MAP.getOrDefault(new SimpleEntry<>(matches, isBonusMatched), LOSE);
    }
}
