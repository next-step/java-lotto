package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class StatisticTest {

    @BeforeEach
    void setUp() {
        Rank.THIRD.count();
        Rank.FORTH.count();
        Rank.FORTH.count();
    }

    @Test
    void sum() {
        int sum = Statistic.sum();
        assertThat(sum).isEqualTo(60000);
    }

    @Test
    void get_yield() {
        Money buy = Money.buy(14000);
        BigDecimal yield = Statistic.getYield(buy);
        assertThat(yield.equals(new BigDecimal(4.00)));
    }
}
