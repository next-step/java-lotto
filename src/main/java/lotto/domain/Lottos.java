package lotto.domain;

import java.util.List;

public class Lottos {

    private final List<Lotto> lottoList;

    public Lottos(List<Lotto> lottos) {
        this.lottoList = lottos;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
