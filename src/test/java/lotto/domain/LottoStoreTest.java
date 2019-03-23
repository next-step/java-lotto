package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class LottoStoreTest {

  @Test
  public void test_insertMoney_1000() {

    // Given
    Money insertMoney = new Money(1000);

    // When
    int lottoQuantity = LottoStore.buy(insertMoney);

    // Then
    assertThat(lottoQuantity).isEqualTo(1);
  }

  @Test
  public void test_insertMoney_1500() {

    // Given
    Money insertMoney = new Money(1500);

    // When
    int lottoQuantity = LottoStore.buy(insertMoney);

    // Then
    assertThat(lottoQuantity).isEqualTo(1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void test_insertMoney_500() {

    // Given
    Money insertMoney = new Money(500);

    // When
    LottoStore.buy(insertMoney);
  }

  @Test
  public void test_insertMoney_14000() {

    // Given
    Money insertMoney = new Money(14000);

    // When
    int lottoQuantity = LottoStore.buy(insertMoney);

    // Then
    assertThat(lottoQuantity).isEqualTo(14);
  }
}
