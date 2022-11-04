package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class StatisticTest {
    @Test
    @DisplayName("통계")
    void test1() {
        // given
        Money money = Money.of(1000);
        Map<Winning, Integer> matching = new HashMap<>();
        matching.put(Winning.THIRD, 1);
        Statistic statistic = new Statistic(money, matching);
        // when
        double earningRate = statistic.getEarningRate();
        // then
        assertThat(earningRate).isEqualTo(5.0D);
    }
}
