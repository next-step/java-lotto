package lotto.domain.game;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.result.Purchase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoMachineTest {

  @ParameterizedTest
  @CsvSource({"10000,10", "1,0", "2320,2"})
  void lottoMachinePurchaseNTicketsBasedOnPrice(int pay, int expectedNTicket) {
    LottoMachine machine = new LottoMachine();
    Purchase tickets = machine.purchase(pay);
    assertThat(tickets.getTickets().size()).isEqualTo(expectedNTicket);
  }
}