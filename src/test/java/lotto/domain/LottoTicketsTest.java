package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.domain.LottoNumber.NUMBER_EXCEPTION_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTicketsTest {
    @Test
    @DisplayName("일정 금액으로 로또 티켓 자동 생성")
    void generate_only_money() {
        int expectedCount = 14;
        LottoTickets lottoTickets = LottoTickets.generate(expectedCount);
        assertThat(lottoTickets.size()).isEqualTo(expectedCount);
    }

    @Test
    @DisplayName("수동 번호로 로또 티켓 수동 생성")
    void generate_only_manual_number() {
        List<int[]> manualNumbers = List.of(new int[]{1, 2, 3, 4, 5, 6}, new int[]{7, 8, 9, 10, 11, 12});
        LottoTickets lottoTickets = LottoTickets.generate(manualNumbers);
        assertThat(lottoTickets.size()).isEqualTo(manualNumbers.size());
    }

    @Test
    @DisplayName("일정 금액과 수동 번호로 로또 티켓 생성")
    void generate_money_and_manual_number() {
        List<int[]> manualNumbers = List.of(new int[]{1, 2, 3, 4, 5, 6}, new int[]{7, 8, 9, 10, 11, 12});
        int expectedCount = 14;
        LottoTickets lottoTickets = LottoTickets.generate(manualNumbers, expectedCount);
        assertThat(lottoTickets.size()).isEqualTo(manualNumbers.size() + expectedCount);
    }

    @Test
    @DisplayName("일정 금액과 잘못된 수동 번호로 로또 티켓 생성 실패")
    void generate_money_and_wrong_manual_number() {
        List<int[]> manualNumbers = List.of(new int[]{1, 2, 3, 4, 5, 6}, new int[]{7, 8, 90, 10, 11, 12});
        int money = 14000;
        assertThatThrownBy(() -> LottoTickets.generate(manualNumbers, money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NUMBER_EXCEPTION_MESSAGE);
    }

    @Test
    @DisplayName("로또 결과 객체 생성")
    void summary_results() {
        LottoTicket winner = new LottoTicket(new int[]{1, 2, 3, 4, 5, 6});
        LottoTickets lottoTickets = new LottoTickets();
        lottoTickets.add(winner);
        lottoTickets.add(new LottoTicket(new int[]{1, 2, 3, 14, 15, 16}));

        SummaryReport report = lottoTickets.getSummary(winner, 45);

        assertThat(report.getTicketCount(PrizeRank.FIRST)).isEqualTo(1);
        assertThat(report.getTicketCount(PrizeRank.FIFTH)).isEqualTo(1);
    }
}
