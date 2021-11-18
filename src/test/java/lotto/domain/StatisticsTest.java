package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class StatisticsTest {

    @DisplayName("수익률 구하기")
    @Test
    void yield() {
        Map<Grade, Long> grades = new HashMap<>();
        grades.put(Grade.FIRST, 1L);
        grades.put(Grade.SECOND, 2L);
        grades.put(Grade.FOURTH, 1L);

        Dollars dollars = new Dollars(4000);
        Statistics statistics = new Statistics(grades, dollars);

        long expectedReward = Grade.FIRST.getReward() + Grade.SECOND.getReward() * 2 + Grade.FOURTH.getReward();
        double expectedRatio = expectedReward / (double) dollars.won();
        assertThat(statistics.yield()).isEqualTo(expectedRatio);
    }

}
