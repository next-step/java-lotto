package lotto.domain;

import java.util.List;

public interface TicketGenerator {

    List<LottoTicket> generate(int count);
}
