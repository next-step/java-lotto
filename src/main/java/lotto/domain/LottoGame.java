package lotto.domain;

public class LottoGame {

  public static final int LOTTO_TICKET_PRICE = 1000;

  public static long toTicketCount(Money money) {
    return money.divide(LOTTO_TICKET_PRICE).getAmount();
  }

  public static Rank match(Lotto lotto, WinLotto winLotto) {
    return winLotto.match(lotto);
  }

}
