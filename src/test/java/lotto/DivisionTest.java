package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DivisionTest {
    @DisplayName("로또 당첨 순위에 따른 당첨금 테스트")
    @Test
    void check_prize_by_division() {
        assertThat(Division.FIRST.getPrize()).isEqualTo(2000000000);
    }
}
