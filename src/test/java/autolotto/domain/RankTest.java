package autolotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @Test
    @DisplayName("숫자일치 갯수에 따른 등수 확인")
    void rank_of_등수확인() {
        Rank rank = Rank.of(3, false);
        assertThat(rank.name()).isEqualTo("FOURTH");
    }

    @Test
    @DisplayName("보너스번호 일치 등수 확인")
    void rank_of_2등보너스확인() {
        Rank rank = Rank.of(3, true);
        assertThat(rank.name()).isEqualTo("SECOND");
    }
    @Test
    @DisplayName("등수에 해당하는 당첨금액 확인")
    void rank_getMoney_금액확인() {
        Rank rank = Rank.of(3, false);
        assertThat(rank.getMoney()).isEqualTo(5000);
    }
}