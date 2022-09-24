package lotto.step2.domain;

import lotto.step2.domain.factory.AutoLottoTicketsFactory;
import lotto.step2.domain.issuelottostrategy.LottoIssueStrategy;

public class LottoMachine {
    public LottoTickets autoIssueLottoTickets(LottoIssueStrategy lottoIssueStrategy) {
        return AutoLottoTicketsFactory.from(lottoIssueStrategy);
    }
}
