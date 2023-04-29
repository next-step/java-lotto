package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoVendingMachine {

  private LottoVendingMachine() {
  }

  public static LottoTickets issueLottoTickets(int tryTotalCount, LottoTickets directInputLottoTickets) {
    int directInputCount = tryDirectInputCount(directInputLottoTickets);

    for (int i = 0; i < tryTotalCount - directInputCount; i++) {
      directInputLottoTickets.addLottoTicket(new RandomLottoStrategy().issue());
    }

    return directInputLottoTickets;
  }

  public static LottoGame startGame(LottoTickets lottoTickets, LottoTicket winningLottoNumbers, int bonusNumber) {
    return new LottoGame(lottoTickets, winningLottoNumbers, new LottoNumber(bonusNumber));
  }

  public static LottoResult lottoResult(LottoGame lottoGame) {
    return lottoGame.play();
  }

  private static int tryDirectInputCount(LottoTickets directInputLottoNumbers) {
    return directInputLottoNumbers.unmodifiedLottoTickets().size();
  }
}
