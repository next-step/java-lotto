package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.machine.LottoGenerator;

public class LottoRepository {

    private List<Lotto> lottos;

    private LottoRepository(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LottoRepository getLottosOf(LottoGenerator lottoGenerator, final int ticketCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            lottos.add(Lotto.from(lottoGenerator.get()));
        }
        return new LottoRepository(lottos);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public int getLottosSize() {
        return this.lottos.size();
    }
}
