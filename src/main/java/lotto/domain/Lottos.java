package lotto.domain;

import java.util.List;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos(LottosGenerator lottosGenerator) {
        this.lottos = lottosGenerator.generate();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
