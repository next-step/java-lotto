package lotto.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StatisticsTest {

    private List<Ticket> tickets;
    private Statistics statistics;

    @Before
    public void setUp() {
        tickets = Arrays.asList(
                new Ticket(LottoNum.toLottoNums(Arrays.asList(1, 2, 3, 7, 8, 9))) // 5등
                , new Ticket(LottoNum.toLottoNums(Arrays.asList(1, 2, 7, 8, 9, 10))) // 꽝
                , new Ticket(LottoNum.toLottoNums(Arrays.asList(1, 2, 3, 4, 5, 6))) // 1등
                , new Ticket(LottoNum.toLottoNums(Arrays.asList(1, 2, 3, 4, 5, 7))) // 2등
                , new Ticket(LottoNum.toLottoNums(Arrays.asList(2, 3, 4, 5, 6, 7))) // 2등
                , new Ticket(LottoNum.toLottoNums(Arrays.asList(1, 2, 3, 4, 5, 8))) // 3등
        );

        WinningTicket winningTicket = new WinningTicket(LottoNum.toLottoNums(Arrays.asList(1, 2, 3, 4, 5, 6)), new LottoNum(7));
        statistics = new Statistics(tickets, winningTicket);
    }

    @Test
    public void 일치_5등_1개() {
        assertThat(statistics.getMatchGroupNum(PrizeType.FIFTH)).isEqualTo(1);
    }

    @Test
    public void 일치_2등_2개() {
        assertThat(statistics.getMatchGroupNum(PrizeType.SECOND)).isEqualTo(2);
    }

    @Test
    public void 일치_3등_1개() {
        assertThat(statistics.getMatchGroupNum(PrizeType.THIRD)).isEqualTo(1);
    }

}
