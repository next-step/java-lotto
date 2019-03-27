package lotto.dto;

import lotto.domain.LottoTicket;

import java.util.List;

public class UserLotto {
    private List<LottoTicket> tickets;

    public UserLotto(List<LottoTicket> tickets) {
        this.tickets = tickets;
    }

    public List<LottoTicket> getTickets() {
        return tickets;
    }

    public LottoMatchResult getLottoMatchResult(WinningLotto winningLotto) {
        LottoMatchResult lottoMatchResult = new LottoMatchResult();
        for (LottoTicket lottoTicket : tickets) {
            lottoTicket.addTicketMatchCount(winningLotto);
            lottoMatchResult.match(lottoTicket.getMatchCount());
        }
        return lottoMatchResult;
    }
}
