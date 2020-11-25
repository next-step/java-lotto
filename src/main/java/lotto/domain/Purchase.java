package lotto.domain;

import lotto.service.NumberSelectionStrategyImpl;

public class Purchase {

    private final LottoCounter lottoCounter;
    private final Lottos manualLottos;

    public Purchase(LottoCounter lottoCounter, Lottos manualLottos) {
        this.lottoCounter = lottoCounter;
        this.manualLottos = manualLottos;
    }

    public static Lottos createLottos(int lottoNum) {
        return new Lottos(lottoNum, new NumberSelectionStrategyImpl());
    }

    public Lottos drawLottos() {
        if (!manualLottos.checkCount(lottoCounter.getManualLottoCount())) {
            throw new IllegalArgumentException("manual lotto count is different with numbers count you input");
        }

        Lottos autoLottos = createLottos(lottoCounter.getAutoLottoCount());
        return manualLottos.concat(autoLottos);
    }
}
