package lotto.step2.domain.issuelottostrategy;

import lotto.step2.domain.LottoTicket;

import java.util.List;

public interface LottoIssueStrategy {
    List<LottoTicket> issueLottoList();
}
