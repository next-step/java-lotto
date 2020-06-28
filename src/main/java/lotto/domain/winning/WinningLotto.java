package lotto.domain.winning;

import lotto.domain.store.LottoNumber;
import lotto.domain.ticket.LottoTicket;

import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {
    private final LottoTicket winningTicket;
    private final LottoNumber bonusNumber;

    public WinningLotto(LottoTicket winningTicket, LottoNumber bonusNumber) {
        if (winningTicket.has(bonusNumber)) {
            throw new IllegalArgumentException();
        }
        this.bonusNumber = bonusNumber;
        this.winningTicket = winningTicket;
    }

    public List<Rank> getLottoRank(final List<LottoTicket> buyingLottoTickets) {
        return buyingLottoTickets.stream()
                .map((buyingLottoTicket -> buyingLottoTicket.getRankBy(winningTicket, bonusNumber)))
                .collect(Collectors.toList());
    }

}
