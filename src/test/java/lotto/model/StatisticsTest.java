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
                new Ticket(Arrays.asList(1, 2, 3, 7, 8, 9))
                ,new Ticket(Arrays.asList(1,2,7,8,9,10))
                ,new Ticket(Arrays.asList(1,7,8,9,10,11))
        );
        statistics = new Statistics(tickets, Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    public void 일치_3개_1개(){

        assertThat(statistics.getMatchGroupNum(3)).isEqualTo(1);
    }

    @Test
    public void 일치_3개_1개수익률() {
        int moneyAmount = 1000;
        double profitRate = statistics.getProfitRate(moneyAmount);
        assertThat(profitRate).isEqualTo(5);
    }
}
