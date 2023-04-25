package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoVendingMachine {

  private LottoVendingMachine() {
  }

  public static LottoTickets issueLottoTickets(int tryRandomCount) {
    LottoTickets lottoTickets = new LottoTickets();

    for (int i = 0; i < tryRandomCount; i++) {
      lottoTickets.addLottoTicket(new RandomLottoStrategy().issue());
    }

    return lottoTickets;
  }

  public static LottoGame startGame(LottoTickets lottoTickets, List<Integer> winningLottoNumbers, int bonusNumber) {
    return new LottoGame(lottoTickets, new LottoTicket(toLottoNumbers(winningLottoNumbers)), new LottoNumber(bonusNumber));
  }

  public static LottoResult lottoResult(LottoGame lottoGame) {
    return lottoGame.play();
  }

  private static List<LottoNumber> toLottoNumbers(List<Integer> lottoNumbers) {
    return lottoNumbers.stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList());
  }
}
