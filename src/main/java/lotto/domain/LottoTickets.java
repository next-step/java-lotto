package lotto.domain;

import java.util.List;
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

    public int matchTicketCount(WinningNumbers winningNumbers, int matchNumberCount) {
        return (int) lottoTicketList.stream()
                .filter(lottoTicket -> lottoTicket.getMatchCount(winningNumbers) == matchNumberCount)
                .count();
    }

    public double earningsRate(WinningNumbers winningNumbers) {
        return Math.floor(100 * (double) earnings(winningNumbers) / (size() * Amount.LOTTO_PRICE))/100.0;
    }

    private long earnings(WinningNumbers winningNumbers) {
        return Stream.of(WinnerPrize.values())
                .mapToLong(winnerPrize -> matchTicketCount(winningNumbers,
                        winnerPrize.getMatchCount()) * winnerPrize.getPrize())
                .sum();
    }

}
