package lottogame.domain;

import lottogame.domain.enums.LottoGameRank;
import lottogame.domain.lotto.LottoResult;
import lottogame.domain.lotto.LottoTicket;
import lottogame.domain.strategy.LottoNumberGenerationStrategy;

public class TicketMachine {
    public LottoTicket createLottoTicket(LottoNumberGenerationStrategy strategy) {
        return new LottoTicket(strategy.getNumbers());
    }

    public LottoGameRank verifyRank(LottoTicket ticket, LottoResult result) {
        return LottoGameRank.findRank(ticket.countSameNumbers(result), ticket.hasBonusNumber(result));
    }
}
