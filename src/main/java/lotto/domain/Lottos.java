package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lottogenerator.LottoGenerator;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(LottoGenerator lottoGenerator, final int buyCount) {
        lottos = new ArrayList<>();
        for (int i = 0; i < buyCount; i++) {
            lottos.add(lottoGenerator.get());
        }
    }

    public List<Lotto> get() {
        return this.lottos;
    }
}
