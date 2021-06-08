package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {

    public Lotto getAutoLotto() {
        Collections.shuffle(LottoNumbers.lottoNumberList);
        List<Integer> lotto = LottoNumbers.lottoNumberList.stream()
                .limit(LottoConstants.NUMBER_COUNT_PER_GAME)
                .collect(Collectors.toList());
        return new Lotto(lotto);
    }

    public Lotto getManualLotto(String manualLottoStr) {
        return new Lotto(manualLottoStr);
    }
}
