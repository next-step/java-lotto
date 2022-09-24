package lotto.step2.domain.strategy.factory;

import lotto.step2.domain.LottoTickets;
import lotto.step2.domain.strategy.issuelottostrategy.IssueLottoStrategy;

public class AutoLottoTicketsFactory {
    public static LottoTickets from(IssueLottoStrategy issueLottoStrategy) {
        return new LottoTickets(issueLottoStrategy.issueLottoList());
    }
}
