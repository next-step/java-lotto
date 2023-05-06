package study.lotto.step2.domain;

public class LottoFactory {
    private final LottoNumbersFactory lottoNumbersFactory;

    public LottoFactory(LottoNumbersFactory autoNumberSelector) {
        this.lottoNumbersFactory = autoNumberSelector;
    }

    public Lotto create() {
        return new Lotto(lottoNumbers());
    }

    private LottoNumbers lottoNumbers() {
        return lottoNumbersFactory.create();
    }
}
