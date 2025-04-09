package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoStatistics;
import lotto.domain.LottoTickets;

public class LottoService {

  public LottoTickets createLottoTickets(int price, List<Lotto> manualLottos) {
    return LottoTickets.of(manualLottos, price);
  }

  public LottoStatistics calculateWinningStatistics(LottoTickets lottoTickets, List<Integer> winningNumbers,
      int bonusBall) {
    return lottoTickets.createWinningStatistics(new Lotto(winningNumbers), bonusBall);
  }
} 