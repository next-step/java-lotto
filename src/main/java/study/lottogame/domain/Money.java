package study.lottogame.domain;

public class Money {
  private int money;

  public Money(int money) {
    if (money < 0) {
      throw new IllegalArgumentException("유효하지 않은 입력입니다");
    }

    this.money = money;
  }

  public int divideMoney(int number) {
    return money / number;
  }

  public int getMoney() {
    return money;
  }
}
