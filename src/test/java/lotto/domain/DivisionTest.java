package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DivisionTest {
    @DisplayName("로또 당첨 순위에 따른 당첨금 테스트")
    @Test
    void check_prize_by_division() {
        assertThat(Division.FIRST.getPrize()).isEqualTo(2000000000);
        assertThat(Division.THIRD.getPrize()).isEqualTo(1500000);
        assertThat(Division.FOURTH.getPrize()).isEqualTo(50000);
        assertThat(Division.FIFTH.getPrize()).isEqualTo(5000);
        assertThat(Division.LOSE.getPrize()).isEqualTo(0);
    }

    @DisplayName("로또 당첨 개수에 따른 Division 테스트")
    @Test
    void check_division_by_match_count_bonus() {
        assertThat(Division.valueOf(6, true)).isEqualTo(Division.FIRST);
        assertThat(Division.valueOf(6, false)).isEqualTo(Division.FIRST);
        assertThat(Division.valueOf(5, true)).isEqualTo(Division.SECOND);
        assertThat(Division.valueOf(5, false)).isEqualTo(Division.THIRD);
        assertThat(Division.valueOf(4, true)).isEqualTo(Division.FOURTH);
        assertThat(Division.valueOf(4, false)).isEqualTo(Division.FOURTH);
        assertThat(Division.valueOf(2, true)).isEqualTo(Division.LOSE);
        assertThat(Division.valueOf(2, false)).isEqualTo(Division.LOSE);
    }
}
