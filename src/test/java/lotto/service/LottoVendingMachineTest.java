package lotto.service;

import lotto.domain.LottoTickets;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class LottoVendingMachineTest {

    @DisplayName("요청한 개수만큼 로또 티켓을 판매할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 4, 5, 10, 100})
    void sell(int counts) {
        // given
        LottoVendingMachine machine = LottoVendingMachine.getInstance();

        // when
        LottoTickets tickets = machine.sell(counts);

        // then
        Assertions.assertThat(tickets.count()).isEqualTo(counts);
    }
}
