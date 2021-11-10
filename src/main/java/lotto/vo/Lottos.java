package lotto.vo;

import lotto.domain.Lotto;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottoList) {
        this.lottos = lottoList;
    }

    public static Lottos create(List<Lotto> lottoList) {
        return new Lottos(lottoList);
    }

    public int count() {
        return lottos.size();
    }
}
