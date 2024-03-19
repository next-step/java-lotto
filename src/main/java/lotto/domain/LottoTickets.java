package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTickets {
    private final static int LOTTO_PRICE = 1000;
    private final List<LottoTicket> lottoTicketList;

    public LottoTickets(Amount amount) {
        this.lottoTicketList = IntStream.range(0, amount.value() / LOTTO_PRICE)
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

}
