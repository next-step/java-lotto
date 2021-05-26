package lotto.statistics;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StatisticTest {

    @Test
    @DisplayName(value = "4개 숫자가 일치한 로또가 5번 나온다면 25만원을 벌었다")
    void earningPrice() {
        Statistic statistic = new Statistic(5, Earn.FOUR_MATCHED);
        assertThat(statistic.earningPrice()).isEqualTo(250_000);
    }

}