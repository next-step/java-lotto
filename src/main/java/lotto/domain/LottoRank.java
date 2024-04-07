package lotto.domain;

import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum LottoRank {
    LOSE(0, false, 0, null),
    FOURTH(3,false, 5_000, "3개 일치 (5000원)-"),
    THIRD(4, false, 50_000, "4개 일치 (50000원)-"),
    SECOND(5, false, 1_500_000, "5개 일치 (1500000원)-"),
    SECOND_BONUS(5, true, 30_000_000, "5개 일치, 보너스 볼 일치(30000000원)-"),
    FIRST(6, false, 2_000_000_000, "6개 일치 (2000000000원)-");

    private static final Map<SimpleEntry<Integer, Boolean>, LottoRank> LOTTO_RANK_MAP = new HashMap<>();

    static {
        Arrays.stream(LottoRank.values())
                .forEach(lottoRank -> LOTTO_RANK_MAP.put(new SimpleEntry<>(lottoRank.matches, lottoRank.isBonusMatched), lottoRank));
    }

    private final int matches;
    private final boolean isBonusMatched;
    private final int prize;
    private final String message;

    LottoRank(int matches, boolean isBonusMatched, int prize, String message) {
        this.matches = matches;
        this.isBonusMatched = isBonusMatched;
        this.prize = prize;
        this.message = message;
    }

    public int getPrize() {
        return this.prize;
    }

    public String getMessage() {
        return this.message;
    }

    public static LottoRank getLottoRank(int matches) {
        return getLottoRank(matches, false);
    }

    public static LottoRank getLottoRank(int matches, boolean isBonusMatched) {
        return LOTTO_RANK_MAP.getOrDefault(new SimpleEntry<>(matches, isBonusMatched), LOSE);
    }
}
