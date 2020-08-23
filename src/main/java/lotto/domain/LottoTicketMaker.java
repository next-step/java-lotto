package lotto.domain;

import java.util.List;

public interface LottoTicketMaker {
    int DEFAULT_LOTTO_NUMBER_COUNT = 6;

    List<LottoTicket> create(BuyCount buyCount);
}
