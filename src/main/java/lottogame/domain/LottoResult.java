package lottogame.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoResult {

    private final LottoTicket lottoTicket;
    private final WinningInfo winningNumbers;
    private final Map<Rank,Long> winningCountPerRank;

    public LottoResult(LottoTicket lottoTicket, WinningInfo winningNumbers) {
        this.lottoTicket = lottoTicket;
        this.winningNumbers = winningNumbers;
        winningCountPerRank = getWinningCountPerRank();
    }

    public String getWinningResultString() {
        StringBuilder stringBuilder = new StringBuilder();

        Arrays.stream(Rank.values())
                .filter(rank -> rank.getWinningMoney() > 0)
                .map(rank -> getWinningResultString(rank))
                .forEach(stringBuilder::append);

        return stringBuilder.toString();
    }

    private String getWinningResultString(Rank key) {
        return String.format("%s- %d개\n",
                key.getWinningResultMessage(),
                getWinningCount(key) );
    }

    Map<Rank, Long> getWinningCountPerRank() {
        return getAutomaticNumbers().stream()
                .map(gameNumber -> gameNumber.getMatchStatus(winningNumbers))
                .collect(Collectors.groupingBy(Rank::valueOf, Collectors.counting()));
    }

    private List<LottoNumberPackage> getAutomaticNumbers() {
        return lottoTicket.getGameNumbers();
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
         return ((double)getTotalWinningMoney() / (double)getPurchaseAmount().getValue());
    }

    private PurchaseAmount getPurchaseAmount() {
        return lottoTicket.getPurchaseAmount();
    }

    public long getTotalWinningMoney() {
        return winningCountPerRank.entrySet()
                .stream()
                .mapToLong(entry -> entry.getKey().getWinningMoney() * entry.getValue())
                .sum();
    }
}