package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoMachine {

    public Lotto generateAutoLotto() {
        Collections.shuffle((List<?>) LottoNumberList.lottoNumberList);
        Set<LottoNumber> lotto = LottoNumberList.lottoNumberList.stream()
                .limit(LottoConstants.NUMBER_COUNT_PER_GAME)
                .collect(Collectors.toSet());
        return new Lotto(lotto);
    }

    public Lotto generateManualLotto(String manualLottoStr) {
        return new Lotto(manualLottoStr);
    }
}
