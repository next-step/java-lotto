package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BallTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    @DisplayName("1~45 사이의 숫자라면 정상적으로 생성된다")
    void new_success_for_between_1_45(int input) {
        assertThatNoException()
            .isThrownBy(() -> new Ball(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void name(int input) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Ball(input));
    }
}
