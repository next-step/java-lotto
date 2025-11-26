package lotto.domain.game;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.lotto.Money;
import lotto.domain.lotto.Purchase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoMachineTest {

  @ParameterizedTest
  @CsvSource({"10000,10", "1000,1", "2320,2"})
  void calculateTotalCountBasedOnBudget(int pay, int expectedCount) {
    LottoMachine machine = new LottoMachine();
    int totalCount = machine.calculateTotalCount(new Money(pay));
    assertThat(totalCount).isEqualTo(expectedCount);
  }

  @ParameterizedTest
  @CsvSource({"3, 10, 10000", "0, 10, 10000", "5, 10, 10000"})
  void createPurchaseWithManualAndTotalCount(int manualCount, int totalCount, int expectedAmount) {
    LottoMachine machine = new LottoMachine();
    Purchase purchase = machine.createPurchase(manualCount, totalCount);
    assertThat(purchase.getPurchaseAmount()).isEqualTo(new Money(expectedAmount));
  }
}