package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.LottoTickets;
import lotto.domain.Money;
import lotto.ui.InputView;
import lotto.ui.Printer;
import lotto.ui.Reader;
import lotto.ui.ResultView;

public class LottoGame {

  private final LottoMachine lottoMachine = new LottoMachine();
  private final InputView inputView = new InputView();
  private final ResultView resultView = new ResultView();

  public void play() {
    Printer.print("구입금액을 입력해 주세요.");
    Money userMoney = Money.from(Reader.read());
    Money lottoPurchasablePrice = Money.toLottoPurchasablePrice(userMoney);
    resultView.printChange(userMoney.subtraction(lottoPurchasablePrice));
    resultView.printPurchaseAmount(lottoPurchasablePrice.ticketPurchasableNumber());

    LottoTickets tickets = lottoMachine.buy(lottoPurchasablePrice);
    resultView.showTicketsInfo(tickets);
  }
}
