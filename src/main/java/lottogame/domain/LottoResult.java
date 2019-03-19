package lottogame.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoResult {

    private final PurchaseAmount purchaseAmount;
    private final List<LottoGame> automaticNumbers;
    private final WinningNumbers winningNumbers;
    private final Map<Rank,Long> winningCountPerRank;

    public LottoResult(LottoTicket lottoTicket, WinningNumbers winningNumbers) {
        purchaseAmount = lottoTicket.getPurchaseAmount();
        automaticNumbers = lottoTicket.getAutomaticNumbers();
        this.winningNumbers = winningNumbers;
        winningCountPerRank = getWinningCountPerRank();
    }

/*    public List<LottoGame> getAutomaticNumbers() {
        return Collections.unmodifiableList(automaticNumbers);
    }

    public WinningNumbers getWinningNumbers() {
        return winningNumbers;
    }*/

    public String getWinningResultString() {
        StringBuilder stringBuilder = new StringBuilder();

        Arrays.stream(Rank.values())
                .filter(rank -> rank.getWinningMoney() > 0)
                .map(rank -> getWinningResultString(rank))
                .forEach(stringBuilder::append);

        return stringBuilder.toString();
    }

    String getWinningResultString(Rank key) {
        return String.format("%d개 일치 (%d원)- %d개\n",
                key.getCountOfMatch(),
                key.getWinningMoney(),
                getWinningCount(key) );
    }

    Map<Rank, Long> getWinningCountPerRank() {
        return automaticNumbers.stream()
                .map(gameNumber -> gameNumber.getMatchedCount(winningNumbers.getNumbers()))
                .collect(Collectors.groupingBy(Rank::valueOf, Collectors.counting()));
    }

    long getWinningCount(Rank key) {
        return Optional.ofNullable(winningCountPerRank)
                        .map(rankResult -> rankResult.get(key))
                        .orElse(0L);
    }

    public String getProfitRateString() {
        return String.format("총 수익률은 %.2f입니다.", getProfitRate());
    }

    double getProfitRate() {
         return ((double)getTotalWinningMoney() / (double)purchaseAmount.getValue());
    }

    public long getTotalWinningMoney() {
        return winningCountPerRank.entrySet()
                .stream()
                .mapToLong(entry -> entry.getKey().getWinningMoney() * entry.getValue())
                .sum();
    }
}