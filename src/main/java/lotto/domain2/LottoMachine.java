package lotto.domain2;

import java.util.List;

public interface LottoMachine {
    Lottos issue(final int countOfTotalLotto, final List<String> directLottos);
}
