package lotto.domain;

import static lotto.domain.Statistics.FIFTH;
import static lotto.domain.Statistics.FIRST;
import static lotto.domain.Statistics.FOURTH;
import static lotto.domain.Statistics.SECOND;
import static lotto.domain.Statistics.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class StatisticsTest {

    @Test
    void 일등_테스트() {
        assertThat(FIRST).isEqualTo(Statistics.getReward(6, false));
    }

    @Test
    void 이등_테스트() {
        assertThat(SECOND).isEqualTo(Statistics.getReward(5, true));
    }

    @Test
    void 삼등_테스트() {
        assertThat(THIRD).isEqualTo(Statistics.getReward(5, false));
    }

    @Test
    void 사등_테스트() {
        assertThat(FOURTH).isEqualTo(Statistics.getReward(4, false));
    }

    @Test
    void 오등_테스트() {
        assertThat(FIFTH).isEqualTo(Statistics.getReward(3, false));
    }
}