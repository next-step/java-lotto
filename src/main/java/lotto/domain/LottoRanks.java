package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import lotto.domain.constant.LottoRank;

public class LottoRanks {

    private static final int LOTTO_PRICE = 1_000;

    private final List<LottoRank> lottoRanks;

    public LottoRanks(List<LottoRank> lottoRanks) {
        this.lottoRanks = lottoRanks;
    }

    public Map<LottoRank, Long> createStatistics() {
        return lottoRanks.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public double createRate() {
        return lottoRanks.stream()
            .mapToInt(LottoRank::getWinningAmount)
            .map(winningAmount -> winningAmount / LOTTO_PRICE)
            .average()
            .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoRanks that = (LottoRanks) o;
        return Objects.equals(lottoRanks, that.lottoRanks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoRanks);
    }

}
