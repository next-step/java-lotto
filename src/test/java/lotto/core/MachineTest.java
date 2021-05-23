package lotto.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("뽑기 기계 테스트")
class MachineTest {
    private final int min = 1;
    private final int max = 45;

    @RepeatedTest(100)
    @DisplayName("랜덤 뽑기")
    public void init1() {
        int number = Machine.draw().number();

        assertThat(number).isBetween(min, max);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9,
            10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
            20, 21, 22, 23, 24, 25, 26, 27, 28, 29,
            30, 31, 32, 33, 34, 35, 36, 37, 38, 39,
            40, 41, 42, 43, 44, 45})
    @DisplayName("지정값 뽑기")
    public void init2(int num) {
        //Machine.draw();
        int number = Machine.draw(num).number();

        assertThat(number).isEqualTo(num);
    }
}