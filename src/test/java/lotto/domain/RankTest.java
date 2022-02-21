package lotto.domain;

import static lotto.domain.Rank.FIFTH;
import static lotto.domain.Rank.FIRST;
import static lotto.domain.Rank.FOURTH;
import static lotto.domain.Rank.NOTHING;
import static lotto.domain.Rank.SECOND;
import static lotto.domain.Rank.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RankTest {

    @Test
    void 일등_테스트() {
        assertThat(FIRST).isEqualTo(Rank.getReward(6, false));
    }

    @Test
    void 이등_테스트() {
        assertThat(SECOND).isEqualTo(Rank.getReward(5, true));
    }

    @Test
    void 삼등_테스트() {
        assertThat(THIRD).isEqualTo(Rank.getReward(5, false));
    }

    @Test
    void 사등_테스트() {
        assertThat(FOURTH).isEqualTo(Rank.getReward(4, false));
    }

    @Test
    void 오등_테스트() {
        assertThat(FIFTH).isEqualTo(Rank.getReward(3, false));
    }

    @Test
    void 꼴등_테스트() {
        assertThat(NOTHING).isEqualTo(Rank.getReward(0, false));
    }
}
