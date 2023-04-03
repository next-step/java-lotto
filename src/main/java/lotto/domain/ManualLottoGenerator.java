package lotto.domain;

public class ManualLottoGenerator implements LottoGenerator {
    private final Lotto manualLotto;

    public ManualLottoGenerator(Lotto manualLotto) {
        this.manualLotto = manualLotto;
    }

    @Override
    public Lotto generate() {
        return this.manualLotto;
    }
}
