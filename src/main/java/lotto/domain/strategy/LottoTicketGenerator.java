package lotto.domain.strategy;

import lotto.domain.item.LottoTickets;

public interface LottoTicketGenerator {

    LottoTickets generate(int count);
}
