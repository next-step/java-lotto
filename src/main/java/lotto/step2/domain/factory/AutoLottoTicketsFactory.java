package lotto.step2.domain.factory;

import lotto.step2.domain.LottoTickets;
import lotto.step2.domain.issuelottostrategy.IssueLottoStrategy;

public class AutoLottoTicketsFactory {
    public static LottoTickets from(IssueLottoStrategy issueLottoStrategy) {
        return new LottoTickets(issueLottoStrategy.issueLottoList());
    }
}
