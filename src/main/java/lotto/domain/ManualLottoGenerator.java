package lotto.domain;

import java.util.List;

public class ManualLottoGenerator implements LottoGenerator {

    private List<Lotto> lottos;

    public ManualLottoGenerator(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    @Override
    public List<Lotto> create() {
        return this.lottos;
    }
}
