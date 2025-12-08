package lotto.domain;

public class AutoLottoGenerator implements LottoGenerator {

    private final LottoCount lottoCount;

    public AutoLottoGenerator(LottoCount lottoCount) {
        this.lottoCount = lottoCount;
    }

    @Override
    public Lottos generate() {
        return new Lottos(lottoCount.value());
    }
}
