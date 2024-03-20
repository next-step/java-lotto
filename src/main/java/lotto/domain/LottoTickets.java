package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTickets {
    private final List<LottoTicket> lottoTicketList;

    public LottoTickets(Amount amount) {
        this.lottoTicketList = IntStream.range(0, amount.value() / Amount.lottoPrice())
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
        return Math.floor(100 * (double) earnings(winningNumbers) / (size() * Amount.lottoPrice()))/100.0;
    }

    private long earnings(WinningNumbers winningNumbers) {
        return matchTicketCount(winningNumbers, WinnerPrize.THREE.getMatchCount()) * WinnerPrize.THREE.getPrize()
                + matchTicketCount(winningNumbers, WinnerPrize.FOUR.getMatchCount()) * WinnerPrize.FOUR.getPrize()
                + matchTicketCount(winningNumbers, WinnerPrize.FIVE.getMatchCount()) * WinnerPrize.FIVE.getPrize()
                + matchTicketCount(winningNumbers, WinnerPrize.SIX.getMatchCount()) * WinnerPrize.SIX.getPrize();
    }

}
