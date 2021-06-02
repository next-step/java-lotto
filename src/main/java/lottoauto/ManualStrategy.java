package lottoauto;

public class ManualStrategy implements LottoGenerateStrategy {

    private final String requestedManualLottoNumbers;

    public ManualStrategy(String requestedManualLottoNumbers) {
        this.requestedManualLottoNumbers = requestedManualLottoNumbers;
    }

    @Override
    public LottoNumbers generateLottoNumbers() {
        return new LottoNumbers(requestedManualLottoNumbers);
    }
}
