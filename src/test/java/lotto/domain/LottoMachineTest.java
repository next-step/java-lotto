package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {
    @ParameterizedTest
    @DisplayName("가격에 맞는 개수만큼 로또 티켓 생성")
    @CsvSource(value = {"3500:3", "9800:9", "15920:15"}, delimiter = ':')
    void checkTicketCountByPayMoney(int money, int expectedLottoTicketCount) {
        List<LottoTicket> lottoTickets = LottoMachine.pay(Money.of(money));
        assertThat(lottoTickets).hasSize(expectedLottoTicketCount);
    }

    @ParameterizedTest
    @DisplayName("가격과 수동 로또티켓 폼을 제출 시 로또 티켓 생성")
    @CsvSource(value = {"3500:3", "9800:9", "15920:15"}, delimiter = ':')
    void manualLottoByCreation(int money, int expectedLottoTicketCount) {
        LottoTicketForm lottoTicketForm = LottoTicketForm.of(1, 2, 3, 4, 5, 6);
        LottoTicketForm lottoTicketForm2 = LottoTicketForm.of(11, 12, 13, 14, 15, 16);
        List<LottoTicket> tickets = LottoMachine.pay(Money.of(money), Arrays.asList(lottoTicketForm, lottoTicketForm2));

        assertThat(tickets).hasSize(expectedLottoTicketCount);
        assertThat(tickets).contains(LottoTicket.of(1, 2, 3, 4, 5, 6), LottoTicket.of(11, 12, 13, 14, 15, 16));
    }
}
