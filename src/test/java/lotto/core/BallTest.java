package lotto.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("로또 볼")
class BallTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9,
            10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
            20, 21, 22, 23, 24, 25, 26, 27, 28, 29,
            30, 31, 32, 33, 34, 35, 36, 37, 38, 39,
            40, 41, 42, 43, 44, 45})
    @DisplayName("정상번호 생성 확인")
    public void init1(int num) {
        Ball ball = new Ball(num);

        assertThat(num).isEqualTo(ball.number());
    }


    @ParameterizedTest
    @ValueSource(ints = {0, 46, -1})
    @DisplayName("비정상번호 생성 확인")
    public void init2(int num) {
        assertThatThrownBy(() -> new Ball(num))
                .isInstanceOf(IllegalArgumentException.class);
    }
}