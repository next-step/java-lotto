package lotto.domain.model;

import java.util.List;

public class LottoTickets {

    private final List<LottoTicket> ticketList;

    private LottoTickets(List<LottoTicket> ticketList) {
        this.ticketList = ticketList;
    }

    public static LottoTickets createFromTicketList(List<LottoTicket> ticketList) {
        return new LottoTickets(ticketList);
    }

    public LottoResult match(LottoTicket winningTicket) {
        LottoResult lottoResult = LottoResult.createEmpty();
        for (LottoTicket lottoTicket : ticketList) {
            LottoRank lottoRank = lottoTicket.findRank(winningTicket);
            lottoResult.update(lottoRank);
        }
        return lottoResult;
    }

    public List<LottoTicket> getTicketList() {
        return ticketList;
    }

    public int size() {
        return ticketList.size();
    }
}
