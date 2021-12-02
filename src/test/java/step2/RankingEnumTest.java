package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.enums.RANKING;

import static org.assertj.core.api.Assertions.assertThat;

public class RankingEnumTest {
    @Test
    @DisplayName("Lotteries 객체 생성")
    void getCorrectCount() {
        assertThat(RANKING.FIRST.getCorrectCount()).isEqualTo(6);
        assertThat(RANKING.FOURTH.getCorrectCount()).isEqualTo(3);
    }

    @Test
    @DisplayName("당첨 등수에 해당되는 상금 get test")
    void getPrizeMoney() {
        assertThat(RANKING.SECOND.getPrizeMoney()).isEqualTo(1500000);
        assertThat(RANKING.THIRD.getPrizeMoney()).isEqualTo(50000);
    }

    @Test
    @DisplayName("맞춘 번호 수를 사용하여 RANKING Field get Test")
    void of() {
        assertThat(RANKING.of(3)).isEqualTo(RANKING.FOURTH);
        assertThat(RANKING.of(6)).isEqualTo(RANKING.FIRST);
    }
}
