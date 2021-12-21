package step2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.*;
import step2.domain.Number;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class StatisticsTest {
    static Lottery lottery;
    static Lotteries lotteries;

    @BeforeAll
    static void before() {
        lottery = Lottery.createFromList(new ArrayList() {{
            add(Number.createFromInt(1));
            add(Number.createFromInt(2));
            add(Number.createFromInt(3));
            add(Number.createFromInt(4));
            add(Number.createFromInt(5));
            add(Number.createFromInt(6));
        }});

        lotteries = Lotteries.createFromList(new ArrayList() {{
            add(lottery);
        }});
    }

    @Test
    @DisplayName("Statistics 객체 생성")
    void create() {
        Statistics statistics = new Statistics(lotteries, lottery, Number.createFromInt(3));
        assertThat(statistics).isEqualTo(new Statistics(lotteries, lottery, Number.createFromInt(3)));
    }

    @Test
    @DisplayName("Statistics 통계 계산")
    void getRanks() {
        Statistics statistics = new Statistics(lotteries, lottery, Number.createFromInt(3));
        assertThat(statistics.getRanks()).isEqualTo(new Ranks(lotteries, lottery, Number.createFromInt(3)));
    }

    @Test
    @DisplayName("Statistics 객체 수익율 계산")
    void calculateProfitRate() {
        Lottery lottery = Lottery.createFromList(new ArrayList() {{
            add(Number.createFromInt(1));
            add(Number.createFromInt(2));
            add(Number.createFromInt(3));
            add(Number.createFromInt(7));
            add(Number.createFromInt(8));
            add(Number.createFromInt(9));
        }});

        Statistics statistics = new Statistics(lotteries, lottery, Number.createFromInt(3));
        assertThat(statistics.calculateProfitRate(5000)).isEqualTo(1);
    }
}
