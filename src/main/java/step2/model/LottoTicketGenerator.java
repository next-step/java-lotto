package step2.model;

import java.util.ArrayList;
import java.util.List;

public class LottoTicketGenerator {

    private LottoTicketGenerator() {
    }

    public static LottoTicket generate(int autoCount, List<Lotto> manualLottos) {
        List<Lotto> lottos = new ArrayList<>(manualLottos);
        for (int i = 0; i < autoCount; i++) {
            lottos.add(Lotto.createAuto(LottoNumberGenerator.generate()));
        }

        return LottoTicket.create(lottos);
    }
}
