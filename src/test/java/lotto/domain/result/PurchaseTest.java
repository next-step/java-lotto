package lotto.domain.result;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.lotto.Money;
import lotto.domain.lotto.Purchase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PurchaseTest {

  @ParameterizedTest
  @CsvSource({
      "1000, 1000, 0, 1000",
      "5000, 1000, 2, 5000",
      "10000, 1000, 5, 10000",
      "6000, 2000, 1, 6000"
  })
  void getSpentAmount(int budget, int pricePerTicket, int manualCount, int expectedAmount) {
    Purchase purchase = new Purchase(new Money(budget), new Money(pricePerTicket), manualCount);
    assertThat(purchase.getSpentAmount()).isEqualTo(new Money(expectedAmount));
  }

  @ParameterizedTest
  @CsvSource({
      "10000, 1000, 3, 7",
      "10000, 1000, 0, 10",
      "10000, 1000, 5, 5"
  })
  void getAutoCount(int budget, int pricePerTicket, int manualCount, int expectedAutoCount) {
    Purchase purchase = new Purchase(new Money(budget), new Money(pricePerTicket), manualCount);
    assertThat(purchase.getAutoCount()).isEqualTo(expectedAutoCount);
  }
}