package lotto.domain;

import java.util.Map;
import java.util.Objects;

public class LottoWinningStatistics {

    private final Map<LottoWinningType, Integer> lottoWinningTypeCountMap;
    private final double yield;

    public LottoWinningStatistics(final Map<LottoWinningType, Integer> lottoWinningTypeCountMap,
                                  final double yield) {
        this.lottoWinningTypeCountMap = lottoWinningTypeCountMap;
        this.yield = yield;
    }

    public Map<LottoWinningType, Integer> getLottoWinningTypeCountMap() {
        return lottoWinningTypeCountMap;
    }

    public double getYield() {
        return yield;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoWinningStatistics that = (LottoWinningStatistics) o;
        return Double.compare(that.yield, yield) == 0 && Objects.equals(lottoWinningTypeCountMap, that.lottoWinningTypeCountMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoWinningTypeCountMap, yield);
    }
}
