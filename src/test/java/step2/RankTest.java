package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.enums.Rank;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    @Test
    @DisplayName("Rank 객체 생성")
    void getCorrectCount() {
        assertThat(Rank.FIRST.getCorrectCount()).isEqualTo(6);
        assertThat(Rank.FOURTH.getCorrectCount()).isEqualTo(4);
    }

    @Test
    @DisplayName("당첨 등수에 해당되는 상금 get test")
    void getPrizeMoney() {
        assertThat(Rank.SECOND.getPrizeMoney()).isEqualTo(3_000_000);
        assertThat(Rank.THIRD.getPrizeMoney()).isEqualTo(1_500_000);
    }

    @Test
    @DisplayName("맞춘 번호 수를 사용하여 RANKING Field get Test")
    void of() {
        assertThat(Rank.of(3, false)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.of(5, false)).isEqualTo(Rank.THIRD);
        assertThat(Rank.of(5, true)).isEqualTo(Rank.SECOND);
    }
}
