package lotto;

import java.util.List;

public class LottoWallet {
    private final List<Lotto> lottos;

    public LottoWallet(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getLottoCount() {
        return lottos.size();
    }

    public Lotto getLotto(int index) {
        return lottos.get(index);
    }
}
