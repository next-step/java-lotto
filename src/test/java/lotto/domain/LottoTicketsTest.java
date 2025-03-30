package lotto.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketsTest {
    private static final int TICKET_AMOUNT = 1000;
    private static LottoTickets tickets;
    private static List<LottoTicket> ticketElements;

    @BeforeAll
    static void beforeAll() {
        ticketElements = Arrays.asList(
                new LottoTicket(List.of(1, 7, 8, 9, 10, 11)),
                new LottoTicket(List.of(1, 2, 8, 9, 10, 11)),
                new LottoTicket(List.of(1, 2, 3, 9, 10, 11)),
                new LottoTicket(List.of(1, 2, 3, 4, 5, 6))
        );

        tickets = new LottoTickets(ticketElements);
    }

    @Test
    @DisplayName("로또 티켓 컬렉션은 개수에 해당하는 로또 티켓을 발급해야 한다.")
    void buyLottoTickets() {
        assertThat(new LottoTickets(5).getCount()).isEqualTo(5);
    }

    @Test
    @DisplayName("로또 티켓 컬렉션은 티켓을 반환한다.")
    void getTickets() {
        assertThat(tickets.getTickets()).containsAll(ticketElements);
    }

    @Test
    @DisplayName("로또 티켓 컬렉션은 티켓의 개수를 반환한다.")
    void getCount() {
        assertThat(tickets.getCount()).isEqualTo(4);
    }

    @Test
    @DisplayName("로또 티켓 컬렉션은 당첨번호를 입력하면 N개의 번호가 일치하는 티켓 개수와 상금을 각각 반환한다.")
    void getRankStatistics() {
        LottoTicket winningTicket = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));

        assertThat(tickets.getRankStatistics(winningTicket))
                .containsEntry(LottoRank.FOURTH, 1)
                .containsEntry(LottoRank.THIRD, 0)
                .containsEntry(LottoRank.SECOND, 0)
                .containsEntry(LottoRank.FIRST, 1);
    }
}