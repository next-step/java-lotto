package lottogame.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos = new ArrayList<>();

    public Lottos(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(new LottoAutoStrategy()));
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}
