package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoPrice;
import lotto.domain.LottoStatistics;
import lotto.domain.LottoTickets;

public class LottoService {

  public LottoTickets createLottoTickets(LottoPrice price, List<Lotto> manualLottos) {
    return LottoTickets.of(manualLottos, price.calculateLottoCount());
  }

  public LottoStatistics calculateWinningStatistics(LottoTickets lottoTickets, Lotto winningNumbers,
      int bonusBall) {
    return lottoTickets.createWinningStatistics(winningNumbers, bonusBall);
  }
} 