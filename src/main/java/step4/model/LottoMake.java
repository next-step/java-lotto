package step4.model;

import step4.utils.NumberSplitUtils;

import java.util.ArrayList;
import java.util.List;

public class LottoMake {

    public List<Lotto> makeAutoLottos(int autoLottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i=0; i < autoLottoCount; i++) {
            lottos.add(new Lotto(new LottoNumbers(new LottoNumber())));
        }

        return lottos;
    }

    public List<Lotto> makeManualLottos(List<String> manualLottoNumber) {
        List<Lotto> lottos = new ArrayList<>();

        for (String numbers : manualLottoNumber) {
            lottos.add(new Lotto(new LottoNumbers(NumberSplitUtils.splitWinNumberString(numbers))));
        }

        return lottos;
    }
}
