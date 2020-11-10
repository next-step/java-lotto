package lotto.service;

import lotto.domain.Lotto;
import lotto.dto.WinningStatistic;

import java.util.Collection;
import java.util.List;

public interface LottoService {
    List<Lotto> buyLottos(int amount);

    WinningStatistic getResult(Lotto winningLotto, Collection<Lotto> boughtLottos);
}
