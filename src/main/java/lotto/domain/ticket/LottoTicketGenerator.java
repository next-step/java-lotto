package lotto.domain.ticket;

import lotto.application.LottoGeneratorService;

public class LottoTicketGenerator {
    private final LottoGeneratorService lottoGeneratorService;

    public LottoTicketGenerator(LottoGeneratorService lottoGeneratorService) {
        this.lottoGeneratorService = lottoGeneratorService;
    }

    public LottoTicket getTicket() {
        return lottoGeneratorService.generateLottoTicket();
    }

}
