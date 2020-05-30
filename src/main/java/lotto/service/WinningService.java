package lotto.service;

import lotto.domain.LottoResult;
import lotto.collections.LottoTickets;
import lotto.collections.WinningNumbers;

public class WinningService {

  public LottoResult calculateLottoMatches(LottoTickets lottoTickets, WinningNumbers winningNumbers) {
    return lottoTickets.calculateLottoResult(winningNumbers);
  }
}
