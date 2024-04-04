package lotto.domain;

import java.util.Arrays;
import java.util.Map;

public enum LottoRank {
    LOSE(0, 0),
    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    FIRST(6, 2_000_000_000);

    private final int matches;
    private final int prize;

    LottoRank(int matches, int prize) {
        this.matches = matches;
        this.prize = prize;
    }

    public int getPrize() {
        return this.prize;
    }

    public static Long getWholePrize(Map<LottoRank, Long> result) {
        long wholePrize = 0L;

        for (LottoRank lottoRank: result.keySet()) {
            wholePrize += lottoRank.getPrize() * result.get(lottoRank);
        }

        return wholePrize;
    }

    public static LottoRank getLottoRank(int matches) {
        return Arrays.stream(values())
                .filter(m -> m.matches == matches)
                .findFirst().orElse(LottoRank.LOSE);
    }
}
