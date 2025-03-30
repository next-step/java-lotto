package step3.lotto.model;

import java.util.List;

public class LottoTicketList {

    private final List<LottoTicket> lottoTickets;

    public LottoTicketList(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public List<LottoTicket> value() {
        return lottoTickets;
    }

    public LottoResult scratchAll(LottoTicket lastWeekWinningTicket, LottoNumber bonusNumber) {
        LottoResult lottoResult = new LottoResult();
        for (LottoTicket lottoTicket : lottoTickets) {
            LottoPrize lottoPrize = lottoTicket.scratch(lastWeekWinningTicket, bonusNumber);
            lottoResult.reflect(lottoPrize);
        }
        return lottoResult;
    }

}
