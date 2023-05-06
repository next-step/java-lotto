package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

@DisplayName("로또 티켓 집합 클래스 테스트")
class LottoTicketsTest {

    @DisplayName("로또 티켓 구입은 1000원 보다 적으면 실패한다")
    @Test
    void lottoTicketsCreate_fail() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoTickets.create(900))
                .withMessage("티켓 구입 금액은 최소 1000원 이상 이여야 합니다");
    }

    @ParameterizedTest(name = "1000원 이상의 로또 티켓을 구입하면 성공한다")
    @CsvSource(value = {"1000:1", "9000:9", "20000:20"}, delimiter = ':')
    void lottoTicketsCreate_success(int lottoTicketCount, int expected) {
        LottoTickets lottoTickets = LottoTickets.create(lottoTicketCount);
        int ticketCount = lottoTickets.findLottoTicketCount();
        assertThat(ticketCount).isEqualTo(expected);
    }

    @DisplayName("보너스번호와 당첨로또를 전달하면 당첨통계결과를 얻을수 있다")
    @Test
    void calculateLottoStatistics() {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        lottoTickets.add(LottoTicket.from(Set.of(1, 2, 3, 4, 5, 6)));
        lottoTickets.add(LottoTicket.from(Set.of(2, 3, 4, 5, 6, 7)));
        lottoTickets.add(LottoTicket.from(Set.of(2, 3, 4, 5, 6, 8)));
        lottoTickets.add(LottoTicket.from(Set.of(3, 4, 5, 6, 7, 8)));
        LottoTickets tickets = new LottoTickets(lottoTickets);

        Set<Integer> winningNumbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoTicket winningLottoTicket = LottoTicket.from(winningNumbers);
        WinningLotto winningLotto = new WinningLotto(winningLottoTicket, 7);

        WinningStatistics winningStatistics = tickets.calculateLottoStatistics(winningLotto);

        assertThat(winningStatistics.getCount(WinningRank.FIRST)).isEqualTo(1);
        assertThat(winningStatistics.getCount(WinningRank.SECOND)).isEqualTo(1);
        assertThat(winningStatistics.getCount(WinningRank.THIRD)).isEqualTo(1);
        assertThat(winningStatistics.getCount(WinningRank.FOURTH)).isEqualTo(1);
    }

}
