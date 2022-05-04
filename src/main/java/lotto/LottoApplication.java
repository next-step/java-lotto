package lotto;

import lotto.domain.LottoFactory;
import lotto.domain.LottoStore;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

  public static void main(String[] args) {
    LottoTickets lottoTickets = LottoStore.buy(Money.wons(InputView.getAmount()));
    ResultView.print(lottoTickets);
    LottoTicket winLottoTicket = LottoFactory.create(InputView.getWinNumbers());
    ResultView.print(lottoTickets.getResultStatistics(winLottoTicket));
  }

}
