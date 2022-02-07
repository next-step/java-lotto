package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.machine.LottoGenerator;

public class LottoRepository {

    private final List<Lotto> lottos = new ArrayList<>();

    public LottoRepository(LottoGenerator lottoGenerator, final int ticketCount) {
        for (int i = 0; i < ticketCount; i++) {
            lottos.add(Lotto.from(lottoGenerator.get()));
        }
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public int getLottosSize() {
        return this.lottos.size();
    }
}
