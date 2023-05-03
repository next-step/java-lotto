package lotto;

import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.strategy.LottoTicketAutoCreateStrategy;
import lotto.dto.CheckWinningRequest;
import lotto.enums.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTicketsTest {
    List<Integer> winningNumber = Arrays.asList(1, 2, 3, 4, 5, 6);

    int bonusNumber = 7;
    List<LottoTicket> lottoTickets = new ArrayList<>();
    LottoTickets tickets;

    @BeforeEach
    void setUp() {
        lottoTickets.add(new LottoTicket(Arrays.asList(8, 21, 23, 41, 42, 43)));
        lottoTickets.add(new LottoTicket(Arrays.asList(3, 5, 11, 16, 32, 38)));
        lottoTickets.add(new LottoTicket(Arrays.asList(7, 11, 16, 35, 36, 44)));
        lottoTickets.add(new LottoTicket(Arrays.asList(1, 8, 11, 31, 41, 42)));
        lottoTickets.add(new LottoTicket(Arrays.asList(13, 14, 16, 38, 42, 45)));
        lottoTickets.add(new LottoTicket(Arrays.asList(7, 11, 30, 40, 42, 43)));
        lottoTickets.add(new LottoTicket(Arrays.asList(2, 13, 22, 32, 38, 45)));
        lottoTickets.add(new LottoTicket(Arrays.asList(23, 25, 33, 36, 39, 41)));
        lottoTickets.add(new LottoTicket(Arrays.asList(1, 3, 5, 14, 22, 45)));
        lottoTickets.add(new LottoTicket(Arrays.asList(5, 9, 38, 41, 43, 44)));
        lottoTickets.add(new LottoTicket(Arrays.asList(2, 8, 9, 18, 19, 21)));
        lottoTickets.add(new LottoTicket(Arrays.asList(13, 14, 18, 21, 23, 35)));
        lottoTickets.add(new LottoTicket(Arrays.asList(17, 21, 29, 37, 42, 45)));
        lottoTickets.add(new LottoTicket(Arrays.asList(3, 8, 27, 30, 35, 44)));
        tickets = new LottoTickets(lottoTickets);
    }


    @Test
    void 자동생성된_로또_갯수_테스트() {
        LottoTicketAutoCreateStrategy autoLotteryService = new LottoTicketAutoCreateStrategy();
        assertThat(LottoTickets.of(6, autoLotteryService).getLottoTickets().size()).isEqualTo(6);
    }

    @Test
    void 총수익률_구하기_테스트() {
        CheckWinningRequest checkWinningRequest = new CheckWinningRequest(winningNumber, bonusNumber);
        assertThat(Math.floor(tickets.getTotalReturn(checkWinningRequest) * 100) / 100.0).isEqualTo(0.35);
    }

    @Test
    void 전체_당첨결과_확인() {
        CheckWinningRequest checkWinningRequest = new CheckWinningRequest(winningNumber, bonusNumber);
        assertThat(tickets.tallyUp(checkWinningRequest).getRankCount().get(Rank.FOURTH_PLACE)).isEqualTo(1);
        assertThat(tickets.tallyUp(checkWinningRequest).getTotalReturn()).isEqualTo(0.35);
    }

}
