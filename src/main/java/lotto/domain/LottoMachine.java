package lotto.domain;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoMachine {

    public Lotto getAutoLotto() {
        Collections.shuffle(LottoNumbers.lottoNumberList);
        Set<Integer> lotto = LottoNumbers.lottoNumberList.stream()
                .limit(LottoConstants.NUMBER_COUNT_PER_GAME)
                .collect(Collectors.toSet());
        return new Lotto(lotto);
    }

    public Lotto getManualLotto(String manualLottoStr) {
        return new Lotto(manualLottoStr);
    }
}
