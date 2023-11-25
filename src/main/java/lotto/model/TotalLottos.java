package lotto.model;

import java.util.List;

public class TotalLottos {
    private final List<Lotto> lottos;

    public TotalLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int lottoCount() {
        return this.lottos.size();
    }

    public List<Lotto> lottoList() {
        return this.lottos;
    }

    public int totalPurchasePrice() {
        return this.lottos.size() * Lotto.LOTTO_PRICE;
    }

}
