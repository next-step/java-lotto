package lotto.step2.domain;

import lotto.step2.domain.strategy.issuelottostrategy.IssueLottoStrategy;

public class AutoLottoTicketsFactory {
    public static LottoTickets from(IssueLottoStrategy issueLottoStrategy) {
        return new LottoTickets(issueLottoStrategy.issueLottoList());
    }
}
