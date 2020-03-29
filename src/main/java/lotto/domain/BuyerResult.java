package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class BuyerResult {
    private final List<Rank> winningResult;
    private final double profitRate;

    public BuyerResult(List<LottoTicket> lottoTickets, LottoTicket winningTicket) {
        winningResult = createWinningResult(lottoTickets, winningTicket);
        profitRate = createProfitRate(lottoTickets);
    }

    private List<Rank> createWinningResult(List<LottoTicket> lottoTickets, LottoTicket winningTicket) {
        List<Integer> winningMatchCounts = lottoTickets.stream()
                .map(lottoTicket -> lottoTicket.compareTo(winningTicket))
                .filter(matchCount -> matchCount >= LottoTicket.WINNING_MIN_COUNT)
                .collect(Collectors.toList());

        return winningMatchCounts.stream()
                .map(Rank::findByMatchCount)
                .collect(Collectors.toList());
    }

    private double createProfitRate(List<LottoTicket> lottoTickets) {
        long winningAmountSum = winningResult.stream()
                .mapToLong(Rank::getAmount)
                .sum();
        double profitRate = ((double) winningAmountSum) / (lottoTickets.size() * LottoTicket.PRICE);
        return Math.round(profitRate * 100) / 100.0;
    }

    public List<Rank> getWinningResult() {
        return winningResult;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
