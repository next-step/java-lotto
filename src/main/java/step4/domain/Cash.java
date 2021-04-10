package step4.domain;

import step4.domain.number.Count;
import step4.exception.InvalidPriceException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Cash {
  private static final Long LOTTO_PRICE = 1000L;
  private static final Cash lottoCache = new Cash(LOTTO_PRICE);
  private static final String ERROR_MESSAGE = "구매를 위한 출금을 할 수 없습니다.";
  private static final String INVALID_MONEY_MESSAGE = "0원 미만의 금액은 지원하지 않습니다.";
  private static final int ROUNDING_SIZE = 2;

  private final Long money;

  public Cash(Long money) {
    if (money < 0) {
      throw new InvalidPriceException(INVALID_MONEY_MESSAGE);
    }
    this.money = money;
  }

  public static Cash getMultipleLottosPrice(Count count) {
    return new Cash(lottoCache.money * count.showCount());
  }

  public Cash withdrawal() {
    if (!isGreaterEqualProductPrice(lottoCache)) {
      throw new InvalidPriceException(ERROR_MESSAGE);
    }
    return new Cash(money - lottoCache.money);
  }

  public Cash withdrawal(Cash notifyBoughtAmount) {
    if (!isGreaterEqualProductPrice(notifyBoughtAmount)) {
      throw new InvalidPriceException(ERROR_MESSAGE);
    }
    return new Cash(money - notifyBoughtAmount.money);
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

  public String divideReturningString(Cash cash) {
    Double number = divide(cash);
    BigDecimal bigDecimal = new BigDecimal(number).setScale(ROUNDING_SIZE, RoundingMode.HALF_UP);
    double roundedYield = bigDecimal.doubleValue();
    return Double.toString(roundedYield);
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
    return money.equals(cash.money);
  }

  @Override
  public int hashCode() {
    return Objects.hash(money);
  }


}
