package domain.model;

import java.util.ArrayList;
import java.util.List;

public class LottoWallet {
    private final List<Lotto> lottos = new ArrayList<>();

    public void addLottos(List<Lotto> lottos) {
        this.lottos.addAll(lottos);
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }
}
