package lotto.domain.result;

import lotto.domain.number.LottoNumber;
import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.LottoTickets;
import lotto.domain.ticket.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {

    public static final int LOTTO_TICKET_PRICE = 1000;
    private LottoTickets lottoTickets;
    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        LottoTicket ticket1 = LottoTicket.of(
                List.of(
                        LottoNumber.of(1), LottoNumber.of(2),
                        LottoNumber.of(3), LottoNumber.of(4),
                        LottoNumber.of(5), LottoNumber.of(6)
                )
        );
        LottoTicket ticket2 = LottoTicket.of(
                List.of(
                        LottoNumber.of(7), LottoNumber.of(8),
                        LottoNumber.of(9), LottoNumber.of(10),
                        LottoNumber.of(11), LottoNumber.of(12)
                )
        );

        lottoTickets = LottoTickets.of(List.of(ticket1, ticket2));

        winningLotto = WinningLotto.of(
                LottoTicket.of(
                        List.of(
                                LottoNumber.of(1), LottoNumber.of(2),
                                LottoNumber.of(3), LottoNumber.of(4),
                                LottoNumber.of(5), LottoNumber.of(6)
                        )
                )
        );
    }

    @Test
    @DisplayName("당첨 순위별 통계 결과를 확인할 수 있다.")
    void calculateLottoStatistics() {
        LottoStatistics statistics = LottoStatistics.of(lottoTickets, winningLotto, 1000);
        Map<Rank, Integer> results = statistics.getResults();

        assertThat(results.get(Rank.FIRST)).isEqualTo(1);
        assertThat(results.get(Rank.NONE)).isEqualTo(1);
    }

    @Test
    @DisplayName("수익률 계산 테스트")
    void calculateProfitRatio() {
        LottoStatistics statistics = LottoStatistics.of(lottoTickets, winningLotto, 1000);

        assertThat(statistics.getProfitRatio()).isGreaterThan(1.0);
    }

    @Test
    @DisplayName("수익률에 따른 평가 메시지를 확인할 수 있다.")
    void getAssessmentBasedOnProfitRatio() {
        LottoStatistics statistics = LottoStatistics.of(lottoTickets, winningLotto, LOTTO_TICKET_PRICE);

        assertThat(statistics.getAssessmentText()).contains("이득");
    }
}