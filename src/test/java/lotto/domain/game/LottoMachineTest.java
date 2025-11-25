package lotto.domain.game;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.lotto.Money;
import lotto.domain.lotto.Purchase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoMachineTest {

  @ParameterizedTest
  @CsvSource({"10000,10000", "1,0", "2320,2000"})
  void lottoMachinePurchaseNTicketsBasedOnPrice(int pay, int expected) {
    LottoMachine machine = new LottoMachine();
    Purchase tickets = machine.purchase(new Money(pay));
    assertThat(tickets.getPurchaseAmount()).isEqualTo(new Money(expected));
  }
}