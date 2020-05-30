package lotto.service;

import lotto.collections.LottoTickets;
import lotto.collections.WinningNumbers;
import lotto.collections.LottoResult;

public class WinningService {

  protected LottoResult calculateLottoMatches(LottoTickets lottoTickets,
      WinningNumbers winningNumbers) {
    return lottoTickets.createLottoResult(winningNumbers);
  }
}
