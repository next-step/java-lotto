package lotto.domain;

import java.util.List;

public class LottoVendingMachine {

  private LottoVendingMachine() {}

  public static LottoTickets issueLottoTickets(int tryRandomCount) {
    LottoTickets lottoTickets = new LottoTickets();

    for (int i = 0; i < tryRandomCount; i++) {
      lottoTickets.addLottoTicket(new RandomLottoStrategy());
    }

    return lottoTickets;
  }

  public static LottoGame startGame(LottoTickets lottoTickets, List<Integer> winningLottoNumbers) {
    return new LottoGame(lottoTickets, new InputLottoStrategy(winningLottoNumbers));
  }

  public static LottoResult lottoResult(LottoGame lottoGame) {
    return lottoGame.play();
  }
}
