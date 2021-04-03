package step2.domain;

import step2.domain.number.Count;
import step2.exception.InvalidPriceException;

import java.util.Objects;

public class Cash {
  private static final int LOTTO_PRICE = 1000;
  private static final Cash lottoCache = new Cash(LOTTO_PRICE);
  private final String ERROR_MESSAGE = "구매를 위한 출금을 할 수 없습니다.";
  private final String INVALID_MONEY_MESSAGE = "0원 미만의 금액은 지원하지 않습니다.";
  private final int money;

  public Cash(int money) {
    if (money < 0) {
      throw new InvalidPriceException(INVALID_MONEY_MESSAGE);
    }
    this.money = money;
  }

  public Cash withdrawal() {
    if (!isGreaterEqualProductPrice(lottoCache)) {
      throw new InvalidPriceException(ERROR_MESSAGE);
    }
    return new Cash(money - lottoCache.money);
  }

  public Cash add(Cash cash) {
    return new Cash(money + cash.money);
  }

  public Cash multiply(Count count) {
    return new Cash(money * count.showCount());
  }

  public Cash notifyBoughtAmount(Count bought) {
    return lottoCache.multiply(bought);
  }

  public Double divide(Cash cash) {
    return (double) money / (double) cash.money;
  }

  public boolean isAvailableToBuyLotto() {
    return isGreaterEqualProductPrice(lottoCache);
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
