package step2.domain;

import step2.domain.number.Count;
import step2.exception.InvalidPriceException;

import java.util.Objects;

public class Cash {
  private final int money;
  private final String ERROR_MESSAGE = "구매를 위한 출금을 할 수 없습니다.";

  public Cash(int money) {
    this.money = money;
  }

  public Cash withdrawal(Cash productPrice) {
    if (!isGreaterEqualProductPrice(productPrice)) {
      throw new InvalidPriceException(ERROR_MESSAGE);
    }
    return new Cash(money - productPrice.money);
  }

  public Cash add(Cash cash){
    return new Cash(money + cash.money);
  }

  public Cash multiply(Count count){
    return new Cash(money * count.showCount());
  }

  public Double divide(Cash cash){
    return  (double)money / (double)cash.money;
  }

  public boolean isGreaterEqualProductPrice(Cash productPrice) {
    return this.money >= productPrice.money;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Cash cash = (Cash) o;
    return money == cash.money;
  }

  @Override
  public int hashCode() {
    return Objects.hash(money);
  }
}
