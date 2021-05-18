package lotto.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("뽑기 기계 테스트")
class MachineTest {

    @RepeatedTest(100)
    @DisplayName("랜덤 뽑기")
    public void init1() {
        int number = Machine.draw().get();

        assertThat(number).isBetween(1, 45);
    }
}