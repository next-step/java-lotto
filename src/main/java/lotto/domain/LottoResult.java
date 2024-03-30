package lotto.domain;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoResult {
    private final Map<WinnerPrize, Integer> result;
    private final double earningRate;

    public LottoResult(LottoTickets lottoTickets, WinningTicket winningTicket) {
        this.result = Stream.of(WinnerPrize.values())
                .collect(Collectors.toMap(
                        winnerPrize -> winnerPrize,
                        winnerPrize -> matchCount(lottoTickets, winnerPrize, winningTicket)));
        this.earningRate = calculateEarningRate(lottoTickets);
    }

    private int matchCount(LottoTickets lottoTickets, WinnerPrize winnerPrize, WinningTicket winningTicket) {
        return (int) lottoTickets.getLottoTicketList().stream()
                .filter(lottoTicket -> winningTicket.rank(lottoTicket) == winnerPrize)
                .count();
    }

    public int winnerCount(WinnerPrize winnerPrize) {
        return result.get(winnerPrize);
    }

    private double calculateEarningRate(LottoTickets lottoTickets) {
        return Math.floor(100 * (double) earnings() / (lottoTickets.size() * Amount.LOTTO_PRICE))/100.0;
    }

    private long earnings() {
        return Stream.of(WinnerPrize.values())
                .mapToLong(winnerPrize -> winnerCount(winnerPrize) * winnerPrize.getPrize())
                .sum();
    }

    public double earningsRate() {
        return this.earningRate;
    }

}
