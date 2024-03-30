package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoTickets {
    private final List<LottoTicket> lottoTicketList;

    public LottoTickets(Amount amount, List<LottoTicket> manualLotto) {
        List<LottoTicket> autoLotto = IntStream.range(0, amount.lottoTicketCount() - manualLotto.size())
                .mapToObj(i -> new LottoTicket())
                .collect(Collectors.toList());

        this.lottoTicketList = Stream.concat(manualLotto.stream(), autoLotto.stream())
                .collect(Collectors.toList());
    }

    public List<LottoTicket> getLottoTicketList() {
        return lottoTicketList;
    }

    public int size() {
        return lottoTicketList.size();
    }

    public LottoResult winnerResult(WinningTicket winningTicket) {
        return new LottoResult(this, winningTicket);
    }

}
