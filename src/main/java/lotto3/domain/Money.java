package lotto3.domain;

public class Money {

  private static final int TICKET_PRICE = 1000;
  private final int money;

  public Money(int money) {
    this.money = money;
    validateThousands(this.money);
    validateIsPositive(this.money);
  }

  private void validateIsPositive(int money) {
    if (money <= 0) {
      throw new IllegalArgumentException("로또 구입 금액은 0보다 커야 합니다.");
    }
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



  public Money buyManualLotto(ManualLottoCount manualLottoCount) {
    int manualLottoPrice = TICKET_PRICE * manualLottoCount.getCount();
    validateEnoughMoneyToBuy(manualLottoPrice);
    return new Money(this.money - manualLottoPrice);
  }

  private void validateEnoughMoneyToBuy(int manualLottoPrice) {
    if(this.money < manualLottoPrice){
      throw new IllegalArgumentException("로또를 구입하기 위한 금액이 부족합니다");
    }
  }
}
