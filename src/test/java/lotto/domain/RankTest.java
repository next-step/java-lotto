package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @Test
    void valueOf_2등() {
        assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND);
    }

    @Test
    void valueOf_3등() {
        assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.THIRD);
    }

    @DisplayName("당첨번호와 5개 일치하지 않을 경우, 나머지 등수에서는 보너스 볼이 적용되지 않음")
    @Test
    void valueOf_4등_보너스볼_일치() {
        assertThat(Rank.valueOf(4, true)).isEqualTo(Rank.FOURTH);
    }

    @Test
    void valueOf_4등_보너스볼_불일치() {
        assertThat(Rank.valueOf(4, false)).isEqualTo(Rank.FOURTH);
    }

    @DisplayName("정해진 등수 외의 값은 MISS")
    @Test
    void valueOf_그외() {
        assertThat(Rank.valueOf(2, true)).isEqualTo(Rank.MISS);
    }
}
