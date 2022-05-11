package lotto.domain;

public class LottoGame {

  public static final int LOTTO_TICKET_PRICE = 1000;

  public static long toTicketCount(Money money) {
    return money.divide(LOTTO_TICKET_PRICE).getAmount();
  }
}
