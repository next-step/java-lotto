package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lottogenerator.LottoGenerator;

public class Lottos {

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos withLottoGenerator(LottoGenerator lottoGenerator, int buyCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < buyCount; i++) {
            lottos.add(lottoGenerator.get());
        }
        return new Lottos(lottos);
    }

    public static Lottos withListLotto(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public List<Lotto> get() {
        return this.lottos;
    }
}
