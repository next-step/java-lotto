package lotto.service;

import lotto.collections.LottoResult;
import lotto.collections.LottoTickets;
import lotto.collections.WinningNumbers;

public class WinningService {

  public LottoResult calculateLottoMatches(LottoTickets lottoTickets,
      WinningNumbers winningNumbers) {
    return lottoTickets.createLottoResult(winningNumbers);
  }
}
