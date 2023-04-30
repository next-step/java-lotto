package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.LottoTickets;
import lotto.domain.Money;
import lotto.ui.Printer;
import lotto.ui.Reader;

public class LottoGame {

  private final LottoMachine lottoMachine = new LottoMachine();

  public void play() {
    Printer.print("구입금액을 입력해 주세요.");
    Money userMoney = Money.from(Reader.read());
    Money lottoPurchasablePrice = Money.toLottoPurchasablePrice(userMoney);
    Printer.printChange(userMoney.subtraction(lottoPurchasablePrice));

    LottoTickets tickets = lottoMachine.buy(lottoPurchasablePrice);
  }
}
