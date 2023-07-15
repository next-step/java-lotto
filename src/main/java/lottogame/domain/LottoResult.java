package lottogame.domain;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoResult {

    private final Map<LottoRank, Long> lottoRankCounts;
    private final Double earningRate;

    public LottoResult(List<LottoRank> lottoRanks) {
        this.lottoRankCounts = lottoRanks.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        this.earningRate = calculateEarningRate(lottoRanks);
    }

    private Double calculateEarningRate(List<LottoRank> lottoRanks) {
        double totalMoney = lottoRanks.size() * LottoTicket.PURCHASABLE_UNIT;
        double earnMoney = lottoRanks.stream()
                .mapToInt(LottoRank::getMoney)
                .sum();

        return earnMoney / totalMoney;
    }

    public Map<LottoRank, Long> getLottoRankCounts() {
        return Collections.unmodifiableMap(lottoRankCounts);
    }

    public Double getEarningRate() {
        return earningRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResult that = (LottoResult) o;
        return Objects.equals(lottoRankCounts, that.lottoRankCounts) && Objects.equals(earningRate, that.earningRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoRankCounts, earningRate);
    }

    @Override
    public String toString() {
        return "LottoResult{" +
                "lottoRankCounts=" + lottoRankCounts +
                ", earningRate=" + earningRate +
                '}';
    }
}
