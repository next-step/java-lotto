package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoBallTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 22, 45})
    void 로또공_클래스에_번호를_부여할_수_있다(int number) {
        LottoBall lottoBall = LottoBall.select(number);
        assertThat(lottoBall).isNotNull();
        assertThat(lottoBall).isEqualTo(LottoBall.select(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 로또공_클래스_생성자에_1과45이외의_값을_입력받으면_예외를_던진다(int number) {
        assertThatThrownBy(() -> LottoBall.select(number)).isInstanceOf(RuntimeException.class);
    }
}
