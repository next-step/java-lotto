package step2;

public class ManualLottoNumberGenerateStrategy implements LottoNumberGenerateStrategy {

    private LottoNumbers lottoNumbers;

    public ManualLottoNumberGenerateStrategy(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public LottoNumbers generateLottoNumbers() {
        return lottoNumbers;
    }

}
