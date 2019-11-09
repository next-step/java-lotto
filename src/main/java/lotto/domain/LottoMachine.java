package lotto.domain;

import java.util.List;

public interface LottoMachine {
    Lottos issue(final int countOfTotalLotto, final List<String> directLottos);
}
