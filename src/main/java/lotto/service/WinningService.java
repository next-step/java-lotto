package lotto.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.collections.LottoResult;
import lotto.collections.LottoTickets;
import lotto.collections.WinningNumbers;

public class WinningService {

  public WinningNumbers createWinningNumbers(String winningNumber) {
    List<Integer> winningNumberBeforeList = Arrays.stream(winningNumber.split(","))
        .map(String::trim)
        .map(Integer::valueOf)
        .collect(Collectors.toList());
    return new WinningNumbers(winningNumberBeforeList);
  }

  public LottoResult calculateLottoMatches(LottoTickets lottoTickets,
      WinningNumbers winningNumbers) {
    return lottoTickets.createLottoResult(winningNumbers);
  }
}
