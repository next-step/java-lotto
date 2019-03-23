package lottogame.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoResult {

    private final PurchaseAmount purchaseAmount;
    private final Map<Rank,Long> winningCountPerRank;

    public LottoResult(LottoResultMaker resultMaker) {
        purchaseAmount = resultMaker.getPurchaseAmount();
        winningCountPerRank = resultMaker.getWinningCountPerRank();
    }

    Map<Rank, Long> getWinningCountPerRank() {
        return winningCountPerRank;
    }

    public List<String> getWinningResultStrings() {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.getWinningMoney() > 0)
                .map(this::getWinningResultString)
                .collect(Collectors.toList());
    }

    private String getWinningResultString(Rank key) {
        return String.format("%s- %d개",
                key.getWinningResultMessage(),
                getWinningCount(key) );
    }

    long getWinningCount(Rank key) {
        return Optional.ofNullable(winningCountPerRank)
                        .map(rankResult -> rankResult.get(key))
                        .orElse(0L);
    }

    public String getProfitRateString() {
        return String.format("총 수익률은 %.2f입니다.", getProfitRate());
    }

    private double getProfitRate() {
         return ((double)getTotalWinningMoney() / (double)purchaseAmount.getValue());
    }

    public long getTotalWinningMoney() {
        return winningCountPerRank.entrySet()
                .stream()
                .mapToLong(entry -> entry.getKey().getWinningMoney() * entry.getValue())
                .sum();
    }
}