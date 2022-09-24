package lotto.step2.domain.factory;

import lotto.step2.domain.LottoTickets;
import lotto.step2.domain.issuelottostrategy.LottoIssueStrategy;

public class AutoLottoTicketsFactory {
    public static LottoTickets from(LottoIssueStrategy lottoIssueStrategy) {
        return new LottoTickets(lottoIssueStrategy.issueLottoList());
    }
}
