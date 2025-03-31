package lotto.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsTest {
    private static LottoTickets tickets;
    private static List<LottoTicket> ticketElements;

    @BeforeAll
    static void beforeAll() {
        ticketElements = Arrays.asList(
                new LottoTicket(List.of(1, 7, 8, 9, 10, 11)),
                new LottoTicket(List.of(1, 2, 3, 9, 10, 11)),
                new LottoTicket(List.of(1, 2, 3, 4, 5, 11)),
                new LottoTicket(List.of(1, 2, 3, 4, 5, 6))
        );

        tickets = new LottoTickets(ticketElements);
    }

    @Test
    @DisplayName("로또 티켓 컬렉션은 개수에 해당하는 로또 티켓을 발급해야 한다.")
    void buyLottoTickets() {
        assertThat(new LottoTickets(ticketElements).getCount()).isEqualTo(4);
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
    @DisplayName("로또 티켓 컬렉션은 당첨번호와 보너스볼(일치)을 입력하면 당첨 통계를 반환한다.")
    void getRankStatistics() {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 11);

        assertThat(tickets.getRankStatistics(winningLotto))
                .containsEntry(LottoRank.FIFTH, 1)
                .containsEntry(LottoRank.FOURTH, 0)
                .containsEntry(LottoRank.THIRD, 0)
                .containsEntry(LottoRank.SECOND, 1)
                .containsEntry(LottoRank.FIRST, 1);
    }

    @Test
    @DisplayName("로또 티켓 컬렉션은 당첨번호와 보너스볼(불일치)을 입력하면 당첨 통계를 반환한다.")
    void getRankStatisticsWithNoBonus() {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 13);

        assertThat(tickets.getRankStatistics(winningLotto))
                .containsEntry(LottoRank.FIFTH, 1)
                .containsEntry(LottoRank.FOURTH, 0)
                .containsEntry(LottoRank.THIRD, 1)
                .containsEntry(LottoRank.SECOND, 0)
                .containsEntry(LottoRank.FIRST, 1);
    }

    @Test
    @DisplayName("로또 당첨 티켓 번호를 입력하면, 총 수익률을 계산한다.")
    void calculateIncome() {
        LottoTickets lottoTickets = new LottoTickets(List.of(
                new LottoTicket(List.of(1, 2, 3, 4, 5, 6)),
                new LottoTicket(List.of(1, 2, 3, 4, 5, 7))
        ));
        WinningLotto winningLotto = new WinningLotto(List.of(1,2,3,4,10,11), 16);

        assertThat(lottoTickets.income(winningLotto)).isEqualTo(100_000);
    }
}