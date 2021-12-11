package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Lotteries;
import step2.domain.Lottery;
import step2.domain.Number;
import step2.domain.Statistics;
import step2.domain.enums.RANKING;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class StatisticsTest {
    @Test
    @DisplayName("Statistics 객체 생성")
    void create() {
        Lottery lottery = Lottery.createFromList(new ArrayList() {{
            add(Number.createFromInt(1));
            add(Number.createFromInt(2));
            add(Number.createFromInt(3));
            add(Number.createFromInt(4));
        }});

        Lotteries lotteries = new Lotteries(new ArrayList() {{
            add(lottery);
        }});

        Statistics statistics = new Statistics(lotteries, Lottery.createFromArray(new String[]{"1","2","3","4"}));
        assertThat(statistics).isEqualTo(new Statistics(lotteries, Lottery.createFromArray(new String[]{"1","2","3","4"})));
    }

    @Test
    @DisplayName("Statistics 객체 통계 계산")
    void getStatistics() {
        Lottery lottery = Lottery.createFromList(new ArrayList() {{
            add(Number.createFromInt(1));
            add(Number.createFromInt(2));
            add(Number.createFromInt(3));
            add(Number.createFromInt(4));
            add(Number.createFromInt(5));
            add(Number.createFromInt(6));
        }});

        Lotteries lotteries = new Lotteries(new ArrayList() {{
            add(lottery);
        }});

        Statistics statistics = new Statistics(lotteries, Lottery.createFromArray(new String[]{"1","2","3","4","5","6"}));
        assertThat(statistics.getStatistics()).containsEntry(RANKING.FIRST, 1);
    }

    @Test
    @DisplayName("Statistics 객체 수익율 계산")
    void calculateProfitRate() {
        Lottery lottery = Lottery.createFromList(new ArrayList() {{
            add(Number.createFromInt(1));
            add(Number.createFromInt(2));
            add(Number.createFromInt(3));
            add(Number.createFromInt(4));
            add(Number.createFromInt(5));
            add(Number.createFromInt(6));
        }});

        Lotteries lotteries = new Lotteries(new ArrayList() {{
            add(lottery);
        }});

        Statistics statistics = new Statistics(lotteries, Lottery.createFromArray(new String[]{"1","2","3","7","8","9"}));
        assertThat(statistics.calculateProfitRate(5000)).isEqualTo(1);
    }
}
