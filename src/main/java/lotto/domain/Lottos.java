package lotto.domain;

import java.util.List;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos(Integer count, LottosGenerator lottosGenerator) {
        this.lottos = lottosGenerator.generate(count);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
