package lotto.domain.ticket;

import lotto.domain.number.LottoNumber;
import lotto.domain.result.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsTest {

    static List<LottoTicket> tickets;

    @BeforeEach
    void setup() {
       tickets = List.of(
                LottoTicket.of(
                        List.of(
                                LottoNumber.of(1), LottoNumber.of(2),
                                LottoNumber.of(3), LottoNumber.of(4),
                                LottoNumber.of(5), LottoNumber.of(6)
                        )
                ),
                LottoTicket.of(
                        List.of(
                                LottoNumber.of(7), LottoNumber.of(8),
                                LottoNumber.of(9), LottoNumber.of(10),
                                LottoNumber.of(11), LottoNumber.of(12)
                        )
                )
        );
    }

    @DisplayName("다수의 로또 티켓을 생성할 수 있다.")
    @Test
    void createMultipleLottoTickets() {
        LottoTickets lottoTickets = LottoTickets.of(tickets);
        assertThat(lottoTickets.size()).isEqualTo(2);
    }

    @DisplayName("로또 티켓 출력 테스트")
    @Test
    void testToStringOfLottoTickets() {
        LottoTickets lottoTickets = LottoTickets.of(tickets);
        String expectedOutput = "[1, 2, 3, 4, 5, 6]\n[7, 8, 9, 10, 11, 12]\n";
        assertThat(lottoTickets.toString()).isEqualTo(expectedOutput);
    }


    @Test
    @DisplayName("당첨 결과에 따른 순위 집계 테스트")
    void countRanksByWinningLotto() {
        LottoTickets lottoTickets = LottoTickets.of(tickets);
        WinningLotto winningLotto = WinningLotto.of(
                LottoTicket.of(
                        List.of(
                                LottoNumber.of(1), LottoNumber.of(2),
                                LottoNumber.of(3), LottoNumber.of(4),
                                LottoNumber.of(5), LottoNumber.of(6)
                        )
                )
        );

        Map<Rank, Integer> rankCounts = lottoTickets.countRanks(winningLotto);

        assertThat(rankCounts.get(Rank.FIRST)).isEqualTo(1);
        assertThat(rankCounts.get(Rank.NONE)).isEqualTo(1);
    }
}
