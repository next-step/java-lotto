package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoRepository;
import lotto.domain.machine.LottoGenerator;

public class TicketDealer {

    public static LottoRepository getLottosOf(LottoGenerator lottoGenerator, final int ticketCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            lottos.add(Lotto.from(lottoGenerator.get()));
        }
        return new LottoRepository(lottos);
    }
}
