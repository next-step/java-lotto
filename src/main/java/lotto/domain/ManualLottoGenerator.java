package lotto.domain;

import java.util.List;

public class ManualLottoGenerator implements LottoGenerator {

    private final List<Lotto> manualList;

    public ManualLottoGenerator(List<Lotto> manualList) {
        this.manualList = manualList;
    }

    @Override
    public Lottos generate() {
        return new Lottos(manualList);
    }
}
