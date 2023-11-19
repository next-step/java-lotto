package autolotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @Test
    @DisplayName("숫자일치 객수에 따른 등수 확인")
    void rank_of_등수확인() {
        Rank rank = Rank.of(3);
        assertThat(rank.name()).isEqualTo("FOURTH");
    }
    @Test
    @DisplayName("등수에 해당하는 당첨금액 확인")
    void rank_getMoney_금액확인() {
        Rank rank = Rank.of(3);
        assertThat(rank.getMoney()).isEqualTo(5000);
    }
}