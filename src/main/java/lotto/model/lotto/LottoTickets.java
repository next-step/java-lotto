package lotto.model.lotto;

import lotto.model.rank.Rank;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {

    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = Collections.unmodifiableList(lottoTickets);
    }

    public List<Rank> getRanks(WinningTicket winningTicket) {
        return lottoTickets.stream()
                .map(winningTicket::drawLotto)
                .collect(Collectors.toList());
    }

}
