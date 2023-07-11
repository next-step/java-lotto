package lotto;

import java.util.EnumMap;
import java.util.List;

public final class LottoResult {

    public static final int DEFAULT_VALUE = 0;
    private final EnumMap<Rank, Integer> lottoResult;

    public LottoResult(final List<Rank> ranks) {
        this.lottoResult = new EnumMap<>(Rank.class);
        ranks.forEach(rank -> this.lottoResult.put(
                rank,
                this.lottoResult.getOrDefault(rank, DEFAULT_VALUE) + 1
        ));
    }

    public int getCount(final Rank rank) {
        return lottoResult.getOrDefault(rank, DEFAULT_VALUE);
    }

    public double calculateProfitRate(final LottoMoney lottoMoney) {
        return -1;
    }
}
