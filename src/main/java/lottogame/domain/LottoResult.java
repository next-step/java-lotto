package lottogame.domain;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoResult {

    private final Map<LottoPrize, Long> lottoPrizeCounts;
    private final Double earningRate;

    public LottoResult(List<LottoPrize> lottoPrizes) {
        this.lottoPrizeCounts = lottoPrizes.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        this.earningRate = calculateEarningRate(lottoPrizes);
    }

    private Double calculateEarningRate(List<LottoPrize> lottoPrizes) {
        double totalMoney = lottoPrizes.size() * LottoTicket.PURCHASABLE_UNIT;
        double earnMoney = lottoPrizes.stream()
                .mapToInt(LottoPrize::getMoney)
                .sum();

        return earnMoney / totalMoney;
    }

    public Map<LottoPrize, Long> getLottoPrizeCounts() {
        return Collections.unmodifiableMap(lottoPrizeCounts);
    }

    public Double getEarningRate() {
        return earningRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResult that = (LottoResult) o;
        return Objects.equals(lottoPrizeCounts, that.lottoPrizeCounts) && Objects.equals(earningRate, that.earningRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoPrizeCounts, earningRate);
    }

    @Override
    public String toString() {
        return "LottoResult{" +
                "lottoPrizeCounts=" + lottoPrizeCounts +
                ", earningRate=" + earningRate +
                '}';
    }
}
