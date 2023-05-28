package model;

import java.util.List;

public class LottoStore {
    private static final int LOTTO_PRICE = 1_000;
    private int passiveCount;
    private int autoCount;

    public LottoStore(int buyAmount, int passiveCount) {
        this.autoCount = buyAmount / LOTTO_PRICE - passiveCount;
        this.passiveCount = passiveCount;
    }

    public int getAutoCount() {
        return autoCount;
    }

    public int getPassiveCount() {
        return passiveCount;
    }

    public Lottos buyAuto() {
        LottoRandomGenerator lottoGenerator = new LottoRandomGenerator();
        return lottoGenerator.generatorLotto(this.autoCount);
    }

    public Lottos buyPassive(List<Lotto> lottos) {
        return new Lottos(lottos);
    }
}
