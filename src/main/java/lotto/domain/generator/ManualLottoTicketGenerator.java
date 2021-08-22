package lotto.domain.generator;

import lotto.domain.LottoTicket;

public class ManualLottoTicketGenerator implements LottoTicketGenerator {
    private final LottoTicket lottoTicket;

    private ManualLottoTicketGenerator(int... lottoTicketNumbers) {
        lottoTicket = LottoTicket.of(lottoTicketNumbers);
    }

    public static ManualLottoTicketGenerator of(int... lottoTicketNumbers) {
        return new ManualLottoTicketGenerator(lottoTicketNumbers);
    }

    public LottoTicket generate() {
        return lottoTicket;
    }
}
