package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {
    private final LottoTicket winningTicket;

    public WinningLotto(LottoTicket winningTicket) {
        this.winningTicket = winningTicket;
    }

    public List<Rank> getLottoRank(final List<LottoTicket> buyingLottoTickets) {
        return buyingLottoTickets.stream()
                .map((buyingLottoTicket -> buyingLottoTicket.getRankBy(winningTicket)))
                .collect(Collectors.toList());
    }

}
