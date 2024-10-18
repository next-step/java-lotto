package lotto.domain.ticket;

import lotto.application.LottoGenerator;

public class LottoTicketGenerator {
    private final LottoGenerator lottoGenerator;

    public LottoTicketGenerator(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public LottoTicket getTicket() {
        return lottoGenerator.generateLottoTicket();
    }

}
