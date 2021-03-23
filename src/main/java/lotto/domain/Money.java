package lotto.domain;

public final class Money {

  private final int money;

  public Money(int money) {
    if (money < 0) {
      throw new IllegalArgumentException("입력한 돈이 음수입니다.");
    }
    this.money = money;
  }

  public int getTryLottoCount(Integer lottoPrice) {
    return this.money / lottoPrice;
  }
}
