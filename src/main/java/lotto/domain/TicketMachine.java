package lotto.domain;

import lotto.domain.entity.LottoTicket;
import lotto.domain.enums.LottoGameRank;
import lotto.domain.vo.LottoResult;

public class TicketMachine {
    public LottoTicket createLottoTicket(NumberGenerationStrategy strategy) {
        return new LottoTicket(strategy.getNumbers());
    }

    public LottoGameRank verifyRank(LottoTicket ticket, LottoResult result) {
        return LottoGameRank.findRank(ticket.countSameNumbers(result.getLottoNumbers()));
    }
}
