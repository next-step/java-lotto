package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {

    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = Collections.unmodifiableList(lottoTickets);
    }

    public List<Rank> getRanks(WinningTicket winningTicket, LottoNumber bonusNumber) {
        return lottoTickets.stream()
                .map(lottoTicket -> winningTicket.getRank(lottoTicket, bonusNumber))
                .collect(Collectors.toList());
    }

}
