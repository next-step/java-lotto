package lotto.service;

import lotto.domain.Lottos;

public class ManualLottosGenerator implements LottosGenerator {
    private final Lottos manualLottos;

    public ManualLottosGenerator(Lottos manualLottos) {
        this.manualLottos = manualLottos;
    }

    @Override
    public Lottos generate() {
        return manualLottos;
    }
}
