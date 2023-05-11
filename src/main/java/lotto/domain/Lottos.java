package lotto.domain;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottoList;

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public List<Lotto> getLottoList() {
        return List.copyOf(lottoList);
    }

    public int getLottoQuantity() {
        return lottoList.size();
    }
}
