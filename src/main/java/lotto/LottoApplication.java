package lotto;

import lotto.domain.LottoFactory;
import lotto.domain.LottoStatistics;
import lotto.domain.LottoStore;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

  public static void main(String[] args) {
    Money money = Money.wons(Integer.parseInt(InputView.getAmount()));
    LottoTickets lottoTickets = LottoStore.buy(money);
    ResultView.print(lottoTickets);

    String winNumbers = InputView.getWinNumbers();
    LottoTicket winLottoTicket = LottoFactory.create(winNumbers.split(","));
    LottoStatistics resultStatistics = lottoTickets.getResultStatistics(winLottoTicket);
    ResultView.print(resultStatistics);
  }

}
