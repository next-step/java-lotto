package domain.lotto;

public class LottoFactory {

    private final LottoGenerator lottoGenerator;

    public LottoFactory(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public Lotto createLotto() {
        return new Lotto(lottoGenerator.generateLotto());
    }
}

