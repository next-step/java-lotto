package study.lotto.domain;

import java.util.Set;

@FunctionalInterface
public interface LottoTicketIssuer {
    LottoTicket issue();
}
