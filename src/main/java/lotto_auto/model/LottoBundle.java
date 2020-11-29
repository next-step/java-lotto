package lotto_auto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class LottoBundle {

    private List<LottoTicket> lottoTickets;

    public LottoBundle(List<LottoTicket> lottoTickets) {
        this.lottoTickets = Collections.unmodifiableList(lottoTickets);
    }

    public int getTicketCount() {
        return lottoTickets.size();
    }

    public List<LottoTicket> export() {
        return Collections.unmodifiableList(lottoTickets);
    }

    public LottoStatistic draw(WinningLotto winningLotto) {
        return new LottoStatistic(lottoTickets.stream()
                .map(lottoTicket -> lottoTicket.draw(winningLotto))
                .collect(Collectors.toList()),
                lottoTickets.size() * LottoTicket.PRICE);
    }

}
