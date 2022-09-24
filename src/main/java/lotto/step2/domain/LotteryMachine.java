package lotto.step2.domain;

import lotto.step2.domain.strategy.issuelottostrategy.IssueLottoStrategy;

public class LotteryMachine {
    public LottoTickets autoIssueLottoTickets(IssueLottoStrategy issueLottoStrategy) {
        return AutoLottoTicketsFactory.from(issueLottoStrategy);
    }
}
