package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.enums.Rank;

import static org.assertj.core.api.Assertions.assertThat;

public class RankingEnumTest {
    @Test
    @DisplayName("Lotteries 객체 생성")
    void getCorrectCount() {
        assertThat(Rank.FIRST.getCorrectCount()).isEqualTo(6);
        assertThat(Rank.FOURTH.getCorrectCount()).isEqualTo(3);
    }

    @Test
    @DisplayName("당첨 등수에 해당되는 상금 get test")
    void getPrizeMoney() {
        assertThat(Rank.SECOND.getPrizeMoney()).isEqualTo(1500000);
        assertThat(Rank.THIRD.getPrizeMoney()).isEqualTo(50000);
    }

    @Test
    @DisplayName("맞춘 번호 수를 사용하여 RANKING Field get Test")
    void of() {
        assertThat(Rank.of(3)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.of(6)).isEqualTo(Rank.FIRST);
    }
}
