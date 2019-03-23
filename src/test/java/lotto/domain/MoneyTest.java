package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class MoneyTest {

  @Test
  public void test_buy() {

    // Given
    Money money = new Money(1000);
    long productAmount = 100;

    // When
    int buyQuantity = money.buy(productAmount);

    // Then
    assertThat(buyQuantity).isEqualTo(10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void test_can_not_buy() {

    // Given
    Money money = new Money(1000);
    long productAmount = 100000;

    // When
    money.buy(productAmount);
  }

  @Test
  public void test_sum() {

    // Given
    Money money = new Money(1000);
    Money sumMoney = new Money(10000);

    // When
    Money resultMoney = money.sum(sumMoney);

    // Then
    assertThat(resultMoney).isEqualTo(new Money(11000));
  }

  @Test
  public void test_yield() {

    // Given
    Money money = new Money(1000);
    Money insertMoney = new Money(10000);

    // When
    double yield = money.yield(insertMoney);

    // Then
    assertThat(yield).isEqualTo(0.1d);
  }
}