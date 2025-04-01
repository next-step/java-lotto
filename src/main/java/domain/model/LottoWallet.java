package domain.model;

import java.util.ArrayList;
import java.util.List;

public class LottoWallet {
    private final List<LottoNumbers> lottos = new ArrayList<>();

    public void addLottos(List<LottoNumbers> lottos) {
        this.lottos.addAll(lottos);
    }

    public List<LottoNumbers> getLottos() {
        return this.lottos;
    }
}
