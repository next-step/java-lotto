package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;

public class LottoRepository {

    private List<Lotto> lottos;

    public LottoRepository(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public int getLottosSize() {
        return this.lottos.size();
    }
}
