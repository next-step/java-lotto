package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {

    private LottoStatistics lottoStatistics;

    @BeforeEach
    void init() {
        lottoStatistics = new LottoStatistics();
    }

    @Test
    void calculateMatchingCounts() throws Exception {
        //given
        List<LottoTicket> lottoTicketList = new ArrayList<>();
        lottoTicketList.add(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottoTicketList.add(new LottoTicket(Arrays.asList(1, 2, 3, 10, 11, 12)));
        lottoTicketList.add(new LottoTicket(Arrays.asList(1, 2, 3, 7, 8, 9)));
        LottoTickets lottoTickets
                = new LottoTickets(lottoTicketList, new RandomNumberCreation());
        WinningTicket winningTicket = new WinningTicket(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                new LottoNumber(7)
        );

        //when
        Map<LottoRank, Integer> matchingCounts
                = lottoStatistics.calculateMatchingCounts(lottoTickets, winningTicket);

        //then
        assertThat(matchingCounts).containsKeys(
                LottoRank.FOURTH,
                LottoRank.THIRD,
                LottoRank.SECOND,
                LottoRank.FIRST).containsValues(0, 1, 2);
    }

    @Test
    void calculateGrossRateOfEarnings() throws Exception {
        //given
        List<LottoTicket> lottoTicketList = new ArrayList<>();
        lottoTicketList.add(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottoTicketList.add(new LottoTicket(Arrays.asList(1, 2, 3, 10, 11, 12)));
        lottoTicketList.add(new LottoTicket(Arrays.asList(1, 2, 3, 7, 8, 9)));
        LottoTickets lottoTickets
                = new LottoTickets(lottoTicketList, new RandomNumberCreation());
        WinningTicket winningTicket = new WinningTicket(
                Arrays.asList(1, 2, 3, 20, 21, 22),
                new LottoNumber(7)
        );
        lottoStatistics.calculateMatchingCounts(lottoTickets, winningTicket);

        //when
        double rate = lottoStatistics.calculateGrossRateOfEarnings(3000);

        //then
        assertThat(rate).isEqualTo((double) 15000 / 3000);
    }
}
