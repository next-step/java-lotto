package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @DisplayName("1000원 짜리 로또를 금액에 맞게 살 수 있다.")
    @ParameterizedTest
    @CsvSource({"1000,1", "2000,2", "3000,3"})
    void generateTicketsLottoTicket(int pay, int count) {
        LottoMachine lottoMachine = LottoMachine.of(FixedLottoNumberStrategy.from(List.of(1,2,3,4,5,6)));

        List<LottoTicket> lottoTickets = lottoMachine.generateTickets(pay);

        assertThat(lottoTickets).hasSize(count);
    }
}
