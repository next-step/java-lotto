package lotto.domain;

import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.LottoWinningTicket;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoBill {
    private final List<LottoTicket> lottoTickets;

    public LottoBill(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public LottoResult drawAllLotto(LottoWinningTicket lottoWinningTicket) {
        return lottoTickets.stream()
                .map(lottoWinningTicket::findMatchingSheet)
                .collect(Collectors.collectingAndThen(Collectors.toList(), LottoResult::new));
    }

    public List<LottoTicket> getAllTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }
}
