package lotto.domain.numbergenerator;

import lotto.domain.LottoNumbers;
import lotto.domain.ManualBuyDetails;

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
