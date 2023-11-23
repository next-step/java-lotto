package step4.model;

import step4.utils.NumberSplitUtils;

import java.util.ArrayList;
import java.util.List;

public class LottoManualMake {

    private final List<String> manualLottoNumber;

    public LottoManualMake(List<String> manualLottoNumber) {
        this.manualLottoNumber = manualLottoNumber;
    }

    public List<Lotto> makeLottos() {
        List<Lotto> lottos = new ArrayList<>();

        for (String numbers : this.manualLottoNumber) {
            lottos.add(new Lotto(new LottoNumbers(NumberSplitUtils.splitWinNumberString(numbers))));
        }

        return lottos;
    }
}
