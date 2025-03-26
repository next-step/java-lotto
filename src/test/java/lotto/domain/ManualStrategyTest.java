package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ManualStrategyTest {
    @DisplayName("사용자 입력값으로 당첨 번호를 생성한다.")
    @Test
    void generateTest() {
        // given
        ManualStrategy manualStrategy = new ManualStrategy("1,2,3,4,5,6");

        // when
        Lotto lotto = manualStrategy.generate();

        // then
        assertThat(lotto).isNotNull();
    }

}
