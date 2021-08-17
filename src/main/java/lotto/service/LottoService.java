package lotto.service;

import lotto.domain.Chance;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;

public class LottoService {
    public LottoTickets execute(Chance chance, LottoGenerator lottoGenerator) {
        LottoTickets lottoTickets = LottoTickets.empty();
        while (chance.isLeft()) {
            LottoTicket lottoTicket = lottoGenerator.generate();
            lottoTickets.add(lottoTicket);
            chance = chance.useOnce();
        }
        return lottoTickets;
    }
}
