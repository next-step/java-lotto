package lotto;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottoList;
    private final int lottoQuantity;

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
        this.lottoQuantity = lottoList.size();
    }

    public List<Lotto> getLottoList() {
        return List.copyOf(lottoList);
    }

    public int getLottoQuantity() {
        return lottoQuantity;
    }
}
