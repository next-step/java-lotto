package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottoStoreTest {

  @Test
  void buyLottoTickets() {
    assertThat(LottoStore.buy(14000)).hasSize(14);
  }
}