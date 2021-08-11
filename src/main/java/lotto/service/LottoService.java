package lotto.service;

import lotto.domain.LottoTicket;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoTickets;

public class LottoService {
    public LottoTickets execute(int chance, LottoGenerator lottoGenerator) {
        LottoTickets lottoTickets = new LottoTickets();
        for (int i = 0; i < chance; i++) {
            LottoTicket lottoTicket = lottoGenerator.generate();
            lottoTickets.add(lottoTicket);
        }
        return lottoTickets;
    }
}
