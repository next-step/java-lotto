package lotto.domain;

public class ManualNumberService implements LottoNumberService {
    private final Numbers manualNumber;

    public ManualNumberService(Numbers manualNumber) {
        this.manualNumber = manualNumber;
    }

    @Override
    public Numbers creation() {
        return manualNumber;
    }
}
