package lotto.domain;

import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class ManualLottoNumberGenerator implements LottoNumberGenerator {

    private ManualBuyDetails manualBuyDetails;

    public ManualLottoNumberGenerator(ManualBuyDetails manualBuyDetails) {
        this.manualBuyDetails = manualBuyDetails;
    }

    @Override
    public List<LottoNumbers> generate() {
        return manualBuyDetails.getLottoNumbers();
    }
}
