package lotto.util;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.request.ManualRequest;

public interface LottoGenerator {
    Lotto generateAutoLotto();
    Lottos generateManualLotto(ManualRequest manualRequest);
}
