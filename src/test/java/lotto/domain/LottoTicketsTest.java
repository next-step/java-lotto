package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsTest {
    List<LottoTicket> lotteries;
    LottoTickets lottoTickets;
    WinStatistics winStatistics;

    @BeforeEach
    void setUp() {
        lotteries = new ArrayList<>();
        lotteries.add(LottoTicket.of(1, 2, 3, 7, 8, 9));
        lotteries.add(LottoTicket.of(1, 2, 3, 4, 8, 9));
        lotteries.add(LottoTicket.of(1, 2, 3, 4, 5, 9));
        lotteries.add(LottoTicket.of(1, 2, 3, 4, 5, 10));
        lotteries.add(LottoTicket.of(1, 2, 3, 4, 5, 6));
        lottoTickets = LottoTickets.from(lotteries);
    }

    @Test
    void 주어진_로토티켓_여러장과_당첨결과가_주어질_때_수익률이_계산된값인_2_5로_일치해야한다() {
        WinnerNumbers winnerNumbers = WinnerNumbers.from(LottoTicket.of(7, 8, 9, 41, 42, 43), LottoBall.select(44));
        winStatistics = lottoTickets.calculateStatistics(winnerNumbers);
        assertThat(winStatistics.getRateOfReturn()).isEqualTo(2.5f);
    }
}
