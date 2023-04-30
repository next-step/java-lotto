package lotto;

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
