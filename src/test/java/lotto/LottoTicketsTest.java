package lotto;

import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.enums.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTicketsTest {
    List<Integer> winningNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
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
    void 총수익률_구하기_테스트() {
        assertThat(Math.floor(tickets.getTotalReturn(winningNumber) * 100) / 100.0).isEqualTo(0.35);
    }

    @Test
    void 전체_당첨결과_확인() {
        assertThat(tickets.tallyUp(winningNumber).getRankCount().get(Rank.FOURTH_PLACE)).isEqualTo(1);
        assertThat(tickets.tallyUp(winningNumber).getTotalReturn()).isEqualTo(0.35);
    }

}
