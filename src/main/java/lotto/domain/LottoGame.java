package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    public Lottos buyManualLottosUsing(List<String> manualLottoStrings) {
        List<Lotto> lottoList = new ArrayList<>();
        for (String manualLottoString : manualLottoStrings) {
            lottoList.add(new Lotto(manualLottoString));
        }
        return new Lottos(lottoList);
    }

}
