package lotto3.domain;

public class Money {

  private static final int TICKET_PRICE = 1000;
  private final int money;

  public Money(int money) {
    this.money = money;
    validateThousands(this.money);
  }

  private void validateThousands(int money) {
    if (money % 1000 != 0) {
      throw new IllegalArgumentException("로또 구입 금액은 천원 단위로 입력해주세요.");
    }
  }

  public int numberOfTickets() {
    return money / TICKET_PRICE;
  }

  public double profitRate(long totalPrizeMoney) {
    return (double) totalPrizeMoney / money;
  }

}
