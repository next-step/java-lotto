package lotto.model;

import lotto.view.InputView;
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
                new Ticket(InputView.toLottoNums(Arrays.asList(1, 2, 3, 7, 8, 9)),false) // 5등
                , new Ticket(InputView.toLottoNums(Arrays.asList(1, 2, 7, 8, 9, 10)),false) // 꽝
                , new Ticket(InputView.toLottoNums(Arrays.asList(1, 2, 3, 4, 5, 6)),false) // 1등
                , new Ticket(InputView.toLottoNums(Arrays.asList(1, 2, 3, 4, 5, 7)),false) // 2등
                , new Ticket(InputView.toLottoNums(Arrays.asList(2, 3, 4, 5, 6, 7)),false) // 2등
                , new Ticket(InputView.toLottoNums(Arrays.asList(1, 2, 3, 4, 5, 8)),false) // 3등
        );

        WinningTicket winningTicket = new WinningTicket(InputView.toLottoNums(Arrays.asList(1, 2, 3, 4, 5, 6)), new LottoNum(7));
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

    @Test
    public void 일치_1등1개_2등2개_3등1개_5등1개_수익률() {

        long moneyAmount = 100000000L;
        double profitRate = statistics.getProfitRate(moneyAmount);
        assertThat(profitRate).isEqualTo(20.61505);
    }
}
