package step4.lotto.model;

import java.util.List;

public class LottoTicketList {

    private final List<LottoTicket> lottoTickets;

    public LottoTicketList(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public List<LottoTicket> value() {
        return lottoTickets;
    }

    public LottoResult scratchAll(LottoTicketWinner lastWeekWinningTicket) {
        LottoResult lottoResult = new LottoResult();
        for (LottoTicket lottoTicket : lottoTickets) {
            LottoPrize lottoPrize = lastWeekWinningTicket.match(lottoTicket);
            lottoResult.reflect(lottoPrize);
        }
        return lottoResult;
    }

}
