package lotto.service;

import lotto.domain.Lotto;
import lotto.dto.WinningNumber;
import lotto.dto.WinningStatistic;

import java.util.Collection;
import java.util.List;

public interface LottoService {
    List<Lotto> buyLottos(int amount);

    WinningStatistic getResult(WinningNumber winningNumber, Collection<Lotto> boughtLottos);
}
