package kr.aterilio.nextstep.techcamp.m1.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoBallTest {

    @DisplayName("로또 생성 시 1-45 범위에 속하지 않는 숫자가 있으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    public void createLottoBallFailed_outOfRange(int ball) {
        assertThatThrownBy(() -> {
            LottoBall.of(ball);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("범위");
    }

    @DisplayName("로또 생성 시 숫자가 아닌 값이 입력되면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"t", "@"})
    public void createLottoBallFailed_notNumeric(String ball) {
        assertThatThrownBy(() -> {
            LottoBall.of(ball);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자");
    }
}
