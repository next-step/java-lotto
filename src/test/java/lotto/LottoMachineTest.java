package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {
    @ParameterizedTest
    @DisplayName("가격에 맞는 개수만큼 로또 티켓 생성")
    @CsvSource(value = {"3500:3", "9800:9", "15920:15"}, delimiter = ':')
    void checkTicketCountByPayMoney(int money, int expectedLottoTicketCount) {
        List<LottoTicket> lottoTickets = LottoMachine.pay(money);
        assertThat(lottoTickets).hasSize(expectedLottoTicketCount);
    }
}
