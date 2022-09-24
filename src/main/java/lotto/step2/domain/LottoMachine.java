package lotto.step2.domain;

import lotto.step2.domain.factory.AutoLottoTicketsFactory;
import lotto.step2.domain.issuelottostrategy.IssueLottoStrategy;

public class LottoMachine {
    public LottoTickets autoIssueLottoTickets(IssueLottoStrategy issueLottoStrategy) {
        return AutoLottoTicketsFactory.from(issueLottoStrategy);
    }
}
