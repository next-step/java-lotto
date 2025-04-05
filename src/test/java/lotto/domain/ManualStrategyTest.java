package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ManualStrategyTest {
    @DisplayName("수동 로또를 생성한다.")
    @Test
    void generateTest() {
        // given
        ManualStrategy manualStrategy = new ManualStrategy("1, 2, 3, 4, 5, 6");

        // when
        Lotto lotto = manualStrategy.generate();

        // then
        assertThat(lotto).isNotNull();
    }
}
