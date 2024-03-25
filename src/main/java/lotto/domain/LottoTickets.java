package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoTickets {
    private final List<LottoTicket> lottoTicketList;

    public LottoTickets(Amount amount) {
        this.lottoTicketList = IntStream.range(0, amount.lottoTicketCount())
                .mapToObj(i -> new LottoTicket())
                .collect(Collectors.toList());
    }

    public List<LottoTicket> getLottoTicketList() {
        return lottoTicketList;
    }

    public int size() {
        return lottoTicketList.size();
    }

    public int winnerCount(WinnerPrize winnerPrize, WinningTicket winningTicket) {
        return (int) lottoTicketList.stream()
                .filter(lottoTicket -> lottoTicket.rank(winningTicket) == winnerPrize)
                .count();
    }

    public double earningsRate(WinningTicket winningTicket) {
        return Math.floor(100 * (double) earnings(winningTicket) / (size() * Amount.LOTTO_PRICE))/100.0;
    }

    private long earnings(WinningTicket winningTicket) {
        return Stream.of(WinnerPrize.values())
                .mapToLong(winnerPrize -> winnerCount(winnerPrize, winningTicket) * winnerPrize.getPrize())
                .sum();
    }

    public Map<WinnerPrize, Integer> winnerCounts(WinningTicket winningTicket) {
        return Stream.of(WinnerPrize.values())
                .collect(Collectors.toMap(
                        winnerPrize -> winnerPrize,
                        winnerPrize -> winnerCount(winnerPrize, winningTicket)));
    }

}
