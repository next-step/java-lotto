package lotto.game;

import lotto.ticket.LottoTicket;
import lotto.ticket.LottoTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 게임은")
class LottoGameTest {

    public static final int PAYMENTS = 14000;

    @DisplayName("지불액이")
    @ParameterizedTest(name = "{0}원일 경우: {1}장의 로또 티켓을 만든다.")
    @CsvSource(value = {"14000:14", "15000:15"}, delimiter = ':')
    void numberOfTicketIsDecidedByPayments(int payments, int totalNumberOfTickets) {
        LottoGame lottoGame = new LottoGame(payments);
        assertThat(lottoGame.lottoTickets().size()).isEqualTo(totalNumberOfTickets);
    }

    @DisplayName("수동으로 번호를 적은 티켓들을 구입 티켓 리스트에 포함한다.")
    @Test
    void ticketsIncludesManualTickets() {
        List<LottoTicket> tickets = tickets();
        LottoGame lottoGame = new LottoGame(PAYMENTS, tickets);
        assertThat(lottoGame.lottoTickets().containsAll(new LottoTickets(tickets).value())).isTrue();
    }

    @DisplayName("수동 티켓과 자동 티켓의 개수를 반환한다.")
    @Test
    void countManualTicketAndAutoTicket() {
        List<LottoTicket> tickets = tickets();
        LottoGame lottoGame = new LottoGame(PAYMENTS, tickets);
        assertThat(lottoGame.manualTicketCount()).isEqualTo(3);
        assertThat(lottoGame.autoTicketCount()).isEqualTo(11);
    }

    private List<LottoTicket> tickets() {
        int[][] numbers = {{8, 21, 23, 41, 42, 43}, {3, 5, 11, 16, 32, 38}, {7, 11, 16, 35, 36, 44}};
        return Arrays.stream(numbers)
                .map(LottoTicket::new)
                .collect(Collectors.toList());
    }

}
