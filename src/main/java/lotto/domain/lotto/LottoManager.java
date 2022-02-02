package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.machine.LottoGenerator;

public class LottoManager {

    private final List<Lotto> lottos = new ArrayList<>();

    public LottoManager(LottoGenerator lottoGenerator, final int ticketCount) {
        for (int i = 0; i < ticketCount; i++) {
            lottos.add(Lotto.from(lottoGenerator.get()));
        }
    }

    public int getLottosSize() {
        return this.lottos.size();
    }
}
