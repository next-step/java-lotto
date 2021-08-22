package lotto.domain.generator;

import lotto.domain.LottoTicket;

public class AutoLottoTicketGenerator implements LottoTicketGenerator {
    private final LottoTicket lottoTicket;

    public AutoLottoTicketGenerator() {
        lottoTicket = LottoTicket.createRandomNumber();
    }

    public LottoTicket generate() {
        return lottoTicket;
    }
}
