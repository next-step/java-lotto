package lotto.io;

import lotto.domain.number.TestLottoNumberFactory;
import lotto.domain.result.LottoStatistics;
import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.LottoTickets;
import lotto.domain.ticket.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


import static lotto.io.ConsoleOutputHandler.PROFITABLE;
import static org.assertj.core.api.Assertions.assertThat;

class ConsoleOutputHandlerTest {

    private static final int LOTTO_TICKET_PRICE = 1000;
    private LottoTickets lottoTickets;
    private WinningLotto winningLotto;

    @BeforeEach
    void setup() {
        List<LottoTicket> tickets = List.of(
                LottoTicket.of(
                        TestLottoNumberFactory.createLottoNumbers(1, 2, 3, 4, 5, 6)
                ),
                LottoTicket.of(
                        TestLottoNumberFactory.createLottoNumbers(7, 8, 9, 10, 11, 12)
                )
        );

        lottoTickets = LottoTickets.of(tickets);

        winningLotto = WinningLotto.of(
                LottoTicket.of(
                        TestLottoNumberFactory.createLottoNumbers(1, 2, 3, 4, 5 ,6)
                )
        );
    }

    @DisplayName("로또 티켓 출력 테스트")
    @Test
    void testToStringOfLottoTickets() {
        ConsoleOutputHandler consoleOutputHandler = new ConsoleOutputHandler();

        String expectedOutput = "[1, 2, 3, 4, 5, 6]\n[7, 8, 9, 10, 11, 12]\n";
        assertThat(consoleOutputHandler.generateLottoTicketsText(lottoTickets)).isEqualTo(expectedOutput);
    }

    @Test
    @DisplayName("수익률에 따른 평가 메시지를 확인할 수 있다.")
    void getAssessmentBasedOnProfitRatio() {
        LottoStatistics statistics = lottoTickets.generateLottoStatistics(winningLotto, LOTTO_TICKET_PRICE);
        ConsoleOutputHandler consoleOutputHandler = new ConsoleOutputHandler();

        assertThat(consoleOutputHandler.getAssessmentText(statistics.getProfitRatio())).contains(PROFITABLE);
    }

}