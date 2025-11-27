package lotto.domain.game;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.lotto.Purchase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoMachineTest {

  @ParameterizedTest
  @CsvSource({"10000, 3, 7", "1000, 0, 1", "10000, 5, 5"})
  void createPurchaseWithBudgetAndManualCount(int budget, int manualCount, int expectedAutoCount) {
    LottoMachine machine = new LottoMachine();
    Purchase purchase = machine.createPurchase(budget, manualCount);
    assertThat(purchase.getAutoCount()).isEqualTo(expectedAutoCount);
  }

  @ParameterizedTest
  @CsvSource({"10000, 3, 10000", "5000, 2, 5000", "2320, 0, 2000"})
  void createPurchaseCalculatesSpentAmount(int budget, int manualCount, int expectedSpent) {
    LottoMachine machine = new LottoMachine();
    Purchase purchase = machine.createPurchase(budget, manualCount);
    assertThat(purchase.getSpentAmount()).isEqualTo(expectedSpent);
  }
}